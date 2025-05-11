package com.example.hellospring.controller;

import com.example.hellospring.service.ArticleService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class PostController {
    private final ArticleService articleService;

    public PostController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/posts")
    public String getPosts(Model model) {
        model.addAttribute("articles", articleService.getAllArticles());
        return "postView";
    }
}
