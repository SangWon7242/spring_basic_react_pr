package com.psw.sbb.basic.boundedContext.article.repositiory;

import com.psw.sbb.basic.boundedContext.article.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class ArticleRepository {
  private List<Article> articles;

  public ArticleRepository() {
    articles = new ArrayList<>();

    makeTestData();
  }

  public void makeTestData() {
    IntStream.rangeClosed(1, 10)
        .forEach(i -> articles.add(new Article(i, "제목" + i, "내용" + i)));
  }

  public List<Article> findAll() {
    return articles;
  }
}
