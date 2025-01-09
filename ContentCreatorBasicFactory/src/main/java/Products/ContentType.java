package Products;

import java.time.LocalDate;

public class ContentType {

    String author = null;
    LocalDate creationDate = null;

    public ContentType(String author, LocalDate creationDate) {
        this.author = author;
        this.creationDate = creationDate;
    }
    
}
