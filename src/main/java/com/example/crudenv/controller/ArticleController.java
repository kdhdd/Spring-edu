package com.example.crudenv.controller;

import com.example.crudenv.dto.ArticleDto;
import com.example.crudenv.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/regis")
    public ResponseEntity<ArticleDto> articleRegister(@RequestBody ArticleDto articleDto) {
        return ResponseEntity.ok(articleService.register(articleDto));
    }

    @GetMapping("/get")
    public ResponseEntity<List<ArticleDto>> getArticles() {
        return ResponseEntity.ok(articleService.getArticles());
    }

}
