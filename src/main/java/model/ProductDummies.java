package model;

import model.*;

public class ProductDummies {

    // Test products
    public static Book bookItaly = new Book(0, "The Name of the Rose", 12.49f, Country.ITALY);
    public static Food chocolateImported = new Food(3, "Imported Chocolate box", 10, Country.GERMANY);
    public static Food chocolateImportedExpensive = new Food(4, "Imported Chocolate box 2", 11.25f, Country.US);
    public static Food chocolateBarLocal = new Food(5, "Chocolate bar", 0.85f, Country.ITALY);
    public static Medicine medicine = new Medicine(8, "Headache Pills", 9.75f, Country.ITALY);
    public static Product musicCD = new Product(10, "Music CD", 14.99f, Country.ITALY);
    public static Product perfumeImported = new Product(11, "Imported bottle of perfume", 27.99f, Country.FRANCE);
    public static Product perfumeImportedExpensive = new Product(12, "Imported bottle of expensive perfume", 47.5f, Country.FRANCE);
    public static Product perfumeLocal = new Product(13, "Bottle of perfume", 18.99f, Country.ITALY);


}
