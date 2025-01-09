package Products.ConcreteProducts;

import Products.ContentType;

import java.time.LocalDate;

public class Ppt extends ContentType {

    String slideTitle;
    String slideContent;

    public Ppt(String author, LocalDate createdDate, String question, String slideContent) {
        super(author, createdDate);
        this.slideTitle = question;
        this.slideContent = slideContent;
    }

    public String getSlideTitle() {
        return this.slideTitle;
    }

    public String getSlideContent() {
        return this.slideContent;
    }

    public void setSlideTitle(String slideTitle) {
        this.slideTitle = slideTitle;
    }

    public void setSlideContent(String slideContent) {
        this.slideContent = slideContent;
    }
}
