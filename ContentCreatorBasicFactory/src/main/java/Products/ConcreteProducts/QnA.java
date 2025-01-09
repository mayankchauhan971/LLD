package Products.ConcreteProducts;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class QnA {

    String question;
    String answer;

    public QnA(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Our question is " + question + " and the answer is " + answer;
    }
}
