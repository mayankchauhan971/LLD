import Creators.ArticleCreator;
import Creators.PptCreator;
import Creators.QuizCreator;
import Products.ConcreteProducts.Article;
import Products.ConcreteProducts.Ppt;
import Products.ConcreteProducts.QnA;
import Products.ConcreteProducts.Quiz;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Logger logger = LogManager.getLogger(Main.class);

        ArticleCreator articleCreator = new ArticleCreator();
        Article a1 = articleCreator.create("author1", LocalDate.now(), "title1", "content1");
        Article a2 = articleCreator.create("author1", LocalDate.now(), "title1", "content1");
        logger.info(a1.getTitle() + " " + a2.getTitle());

        QuizCreator quizCreator = new QuizCreator();
        QnA q1 = new QnA("question1", "answer1");
        QnA q2 = new QnA("question2", "answer2");

        Quiz quiz1 = quizCreator.create("author1", LocalDate.now(), List.of(q1, q2));
        logger.info(quiz1.toString());

        PptCreator pptCreator = new PptCreator();
        Ppt p1 = pptCreator.create("author1", LocalDate.now(), "slideTitle1", "slideContent1");
        Ppt p2 = pptCreator.create("author1", LocalDate.now(), "slideTitle2", "slideContent2");
        logger.info(p1.getSlideContent() + " " + p2.getSlideContent());

    }
}