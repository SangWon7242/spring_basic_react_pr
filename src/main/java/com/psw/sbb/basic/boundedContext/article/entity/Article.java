package com.psw.sbb.basic.boundedContext.article.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Article {
  private static long lastId;
  private long id;
  private String subject;
  private String content;

  static {
    lastId = 0;
  }

  public Article(String subject, String content) {
    this(++lastId, subject, content);
  }
}
