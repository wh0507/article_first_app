package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter @Setter
public class ArticleDto {

    private Long id;

    private String title;

    private String content;

    public Article toEntity() {
        return new Article(id, title, content);
    }
}
