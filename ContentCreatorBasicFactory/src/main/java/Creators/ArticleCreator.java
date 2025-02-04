package Creators;

import Products.ConcreteProducts.Article;

import java.time.LocalDate;

public class ArticleCreator {

    public Article create(String author, LocalDate creationDate, String title, String content) {
        return new Article(author, creationDate, title, content);
    }
}
