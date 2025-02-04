package Products.ConcreteProducts;

import Products.ContentType;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Article extends ContentType {
    String title;
    String content;

    public Article(String author, LocalDate creationDate, String title, String content) {
        super(author, creationDate);
        this.title = title;
        this.content = content;
    }

}
