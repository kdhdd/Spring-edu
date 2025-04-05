package com.example.crudenv.dto;

import com.example.crudenv.entity.Article;
import com.example.crudenv.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {
    private Long id;
    private String title;
    private String content;

    private List<CommentDto> comments;

    public static ArticleDto entitiyToDto(Article article) {
        return ArticleDto.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .comments(
                        article.getComments()
                                .stream()
                                .map(CommentDto::entityToDto)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
