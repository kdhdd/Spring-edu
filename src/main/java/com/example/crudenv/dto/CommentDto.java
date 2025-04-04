package com.example.crudenv.dto;

import com.example.crudenv.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Long articleId;
    private String comment;

    public static CommentDto entityToDto(Comment comment) {
        return CommentDto.builder()
                .articleId(comment.getArticle().getId())
                .comment(comment.getComment())
                .build();
    }

}
