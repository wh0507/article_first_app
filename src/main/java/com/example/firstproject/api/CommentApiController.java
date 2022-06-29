package com.example.firstproject.api;


import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.entity.Comment;
import com.example.firstproject.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentApiController {

    private final CommentService commentService;

    //コメント照会
    @GetMapping("api/articles/{articleId}/comments")
    public ResponseEntity<List<CommentDto>> comments(@PathVariable Long articleId) {
        //Serviceへ
        List<CommentDto> dtos = commentService.comments(articleId);

        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    //コメント生成
    @PostMapping("/api/articles/{articleId}/comments")
    public ResponseEntity<CommentDto> create(@PathVariable Long articleId,
                                             @RequestBody CommentDto dto) {

        CommentDto createDto = commentService.create(articleId, dto);

        return ResponseEntity.status(HttpStatus.OK).body(createDto);
    }

    //コメント修正
    @PatchMapping("/api/comments/{id}")
    public ResponseEntity<CommentDto> update(@PathVariable Long id,
                                             @RequestBody CommentDto dto) {

        CommentDto updateDto = commentService.update(id, dto);

        return ResponseEntity.status(HttpStatus.OK).body(updateDto);
    }
    //コメント削除
    @DeleteMapping("/api/comments/{id}")
    public ResponseEntity<CommentDto> delete(@PathVariable Long id){

        CommentDto updateDto = commentService.delete(id);

        return ResponseEntity.status(HttpStatus.OK).body(updateDto);
    }


}
