package com.example.firstproject.entity;

import com.example.firstproject.dto.CommentDto;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter @Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "article_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Article article;

    @Column
    private String nickname;

    @Column
    private String body;

    public static Comment createComment(CommentDto dto, Article article) {

        if (dto.getId() != null)
            throw new IllegalArgumentException("コメント生成失敗！コメントのidがないはずです。");
        if (dto.getArticleId() != article.getId())
            throw new IllegalArgumentException("コメント生成失敗！投稿のidが無効です。");

        return new Comment(
                dto.getId(),
                article,
                dto.getNickname(),
                dto.getBody()
        );
    }

    public void patch(CommentDto dto) {

        if (this.id != dto.getId())
            throw new IllegalArgumentException("コメント修正失敗！無効なIDが入力されました。");

        if (dto.getNickname() != null)
            this.nickname = dto.getNickname();

        if (dto.getBody() != null)
            this.body = dto.getBody();
    }

}
