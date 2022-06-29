package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    @DisplayName("特定の投稿のすべてのコメント照会")
    void findByArticleId() {
        /* case 1:  4番の投稿のすべてのコメント照会　*/
        {
            Long articleId = 4L;

            List<Comment> comments = commentRepository.findByArticleId(articleId);

            Article article = new Article(4L, "映画は?", "コメントGO！");
            Comment a = new Comment(1L, article, "Sato", "Marvel");
            Comment b = new Comment(2L, article, "Okahara", "Starwars");
            Comment c = new Comment(3L, article, "Yamato", "Parasite");
            List<Comment> expected = Arrays.asList(a, b, c);

            assertEquals(expected.toString(), comments.toString(), "4番の投稿すべて出力");

        }

        /* Case 2: 1番の投稿のすべてのコメント照会 */
        {
            // 준비
            Long articleId = 1L;
            // 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);
            // 예상
            Article article = new Article(1L, "ああああ", "1111");
            List<Comment> expected = Arrays.asList();
            // 검증
            assertEquals(expected.toString(), comments.toString(), "1番の投稿はコメントなし");
        }
    }

    @Test
    @DisplayName("特定のニックネームのすべてのコメント")
    void findByNickname() {
        /* Case 1: "Park"의 모든 댓글 조회 */
        {
            // 준비
            String nickname = "Sato";
            // 수행
            List<Comment> comments = commentRepository.findByNickname(nickname);
            // 예상
            Comment a = new Comment(1L, new Article(4L, "映画は?", "コメントGO！"), nickname, "Marvel");
            Comment b = new Comment(4L, new Article(5L, "食べ物は?", "コメントGOGO！"), nickname, "チキン");
            Comment c = new Comment(7L, new Article(6L, "趣味は?", "コメントGOGOGO！"), nickname, "ダイビング");
            List<Comment> expected = Arrays.asList(a, b, c);
            // 검증
            assertEquals(expected.toString(), comments.toString(), "Sato 모든 댓글을 출력!");
        }
    }
}