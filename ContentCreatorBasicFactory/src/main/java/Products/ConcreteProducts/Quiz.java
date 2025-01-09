package Products.ConcreteProducts;

import Products.ContentType;

import java.time.LocalDate;
import java.util.List;

public class Quiz extends ContentType {
    List<QnA> questions;

    public Quiz(String author, LocalDate creationDate, List<QnA> questions) {
        super(author, creationDate);
        this.questions = questions;
    }

    @Override
    public String toString() {
        return questions.stream().map(QnA::toString).reduce((a,b) -> a + " " + b).orElse("Oops");
    }
}
