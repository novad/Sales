package model;

public class Food extends Product{
    public Food(int productID, String name, float unitPrice, Country country) {
        super(productID, name, unitPrice, country, Category.FOOD);
    }
}
