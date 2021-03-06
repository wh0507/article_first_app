package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleDto;
import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.service.ArticleService;
import com.example.firstproject.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor //생성자 자동 생성 및 final 변수를 의존관계를 자동으로 설정해 준다.
@RequestMapping(value = "/articles")
public class ArticleController {

    private final ArticleRepository articleRepository;
    private final ArticleService articleService;

    private final CommentService commentService;

    @GetMapping
    public String home() {
        return "articles/home";
    }

    @GetMapping("/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/create")
    public String createArticle(ArticleDto articleDto) {
        log.info(articleDto.toString());

        Article article = articleDto.toEntity();
        log.info(article.toString());

        Article saved = articleRepository.save(article);
        log.info(saved.toString());

        return "redirect:/articles/" + saved.getId();
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Long id , Model model) {
        log.info("id = " + id);

        Article articleEntity = articleRepository.findById(id).orElse(null);
        List<CommentDto> commentsDtos = commentService.comments(id);

        model.addAttribute("article", articleEntity);
        model.addAttribute("commentDtos", commentsDtos);

        return "articles/show";
    }

    @GetMapping("/list")
    public String index(Model model, @PageableDefault(size = 4) Pageable pageable) {
        Page<Article> articles = articleRepository.findAll(pageable);
//        Page<Article> articles = articleRepository.findByTitleContainingOrContentContaining(searchText, searchText, pageable);
        int startPage = Math.max(1, articles.getPageable().getPageNumber() - 4);
        int endPage = Math.min(articles.getTotalPages(), articles.getPageable().getPageNumber() + 4);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("articleList", articles);
        return "articles/index";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Article articleEntity = articleRepository.findById(id).orElse(null);

        model.addAttribute("article", articleEntity);

        return "articles/edit";
    }

    @PostMapping("/update")
    public String update(ArticleDto articleDto) {
        log.info(articleDto.toString());

        Article articleEntity = articleDto.toEntity();

        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);

        if (target != null) {
            articleRepository.save(articleEntity);
        }

        return  "redirect:/articles/" + articleEntity.getId();
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr) {
        log.info("削除リクエスト");
        Article target = articleRepository.findById(id).orElse(null);
//        articleService.delete(target.getId());

        if (target != null) {
            articleRepository.delete(target);
            rttr.addFlashAttribute("msg", "削除完了！");
        } else if (commentService.comments(id) != null) {
            rttr.addFlashAttribute("msg1", "コメントがありますが、削除してもよろしいですか？");
        }

        return "redirect:/articles/list";
    }

}
