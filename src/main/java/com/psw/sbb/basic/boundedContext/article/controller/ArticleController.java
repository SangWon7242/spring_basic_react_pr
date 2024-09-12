package com.psw.sbb.basic.boundedContext.article.controller;

import com.psw.sbb.basic.boundedContext.article.entity.Article;
import com.psw.sbb.basic.boundedContext.article.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ArticleController {
  private final ArticleService articleService;

  public ArticleController(ArticleService articleService) {
    this.articleService = articleService;
  }

  @GetMapping("/list")
  @ResponseBody
  public List<Article> showList() {
    List<Article> articles = articleService.findByArticles();
    return articles;
  }
}
