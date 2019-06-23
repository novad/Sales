package model;

public class Book extends Product{
    public Book(int productID, String name, float unitPrice, Country country) {
        super(productID, name, unitPrice, country, Category.BOOK);
    }
}
