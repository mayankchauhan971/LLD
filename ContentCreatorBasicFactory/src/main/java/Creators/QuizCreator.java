package Creators;

import Products.ConcreteProducts.QnA;
import Products.ConcreteProducts.Quiz;

import java.time.LocalDate;
import java.util.List;

public class QuizCreator {

    public Quiz create(String author, LocalDate creationDate, List<QnA> questionAnswers) {
       return new Quiz(author, creationDate, questionAnswers);
   }
}
