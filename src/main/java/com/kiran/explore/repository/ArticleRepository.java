package com.kiran.explore.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiran.explore.models.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Optional<Article> findById(Long id);
    void deleteById(Long id);
}