package model;

public class Product {
    private int productID;
    private String name;
    private float shelfPrice;
    private Country countryOfOrigin;
    private Category category;

    public Product(int productID, String name, float shelfPrice, Country country) {
        this.productID = productID;
        this.name = name;
        this.shelfPrice = shelfPrice;
        this.countryOfOrigin = country;
    }

    /* Constructor for the classes that inherit Product */
    Product(int productID, String name, float shelfPrice, Country country, Category category) {
        this(productID, name, shelfPrice, country);
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public float getShelfPrice() {
        return shelfPrice;
    }

    public Country getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public Category getCategory() {
        return category;
    }
}
