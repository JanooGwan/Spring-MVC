package com.example.hellospring.repository;

import com.example.hellospring.domain.Article;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ArticleRepository {
    private final List<Article> articles = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();

    public List<Article> findAll() {
        return articles;
    }

    public Optional<Article> findById(Long id) {
        return articles.stream().filter(a -> a.getId().equals(id)).findFirst();
    }

    public Article save(Article article) {
        article.setId(idCounter.getAndIncrement());
        article.setCreatedDate(LocalDateTime.now());
        article.setModifiedDate(LocalDateTime.now());
        articles.add(article);
        return article;
    }

    public boolean deleteById(Long id) {
        return articles.removeIf(a -> a.getId().equals(id));
    }
}
