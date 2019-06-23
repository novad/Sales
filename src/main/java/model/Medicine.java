package model;

public class Medicine extends Product{
    public Medicine(int productID, String name, float unitPrice, Country country) {
        super(productID, name, unitPrice, country, Category.MEDICINE);
    }
}
