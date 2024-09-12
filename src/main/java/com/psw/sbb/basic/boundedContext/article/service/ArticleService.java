package com.psw.sbb.basic.boundedContext.article.service;

import com.psw.sbb.basic.boundedContext.article.entity.Article;
import com.psw.sbb.basic.boundedContext.article.repositiory.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
  private final ArticleRepository articleRepository;

  public ArticleService(ArticleRepository articleRepository) {
    this.articleRepository = articleRepository;
  }

  public List<Article> findByArticles() {
    return articleRepository.findByArticles();
  }
}
