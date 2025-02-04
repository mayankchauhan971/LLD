package Creators;

import Products.ConcreteProducts.Ppt;

import java.time.LocalDate;

public class PptCreator {
    public Ppt create(String author, LocalDate creationDate, String slideTitle, String slideContent) {
       return new Ppt(author, creationDate, slideTitle, slideContent);
   }
}
