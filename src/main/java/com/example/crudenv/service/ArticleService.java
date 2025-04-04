package com.example.crudenv.service;

import com.example.crudenv.dto.ArticleDto;
import com.example.crudenv.entity.Article;
import com.example.crudenv.repository.ArticleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional
    public ArticleDto register(ArticleDto articleDto) {

        Article article = Article.builder()
                .title(articleDto.getTitle())
                .content(articleDto.getContent())
                .build();

        article = articleRepository.save(article);
        return ArticleDto.entitiyToDto(article);
    }

    public List<ArticleDto> getArticles() {
        List<Article> articles = articleRepository.findAll();
        return articles.stream()
                .map(ArticleDto::entitiyToDto)
                .collect(Collectors.toList());
    }
}
