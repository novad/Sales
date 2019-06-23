package model;

public class SaleItem {
    private Product product;
    private int units;
    private float subTotal;
    private float taxesTotal;

    public SaleItem(Product product, int units) {
        this.product = product;
        this.units = units;
        this.subTotal = product.getShelfPrice() * this.units;
    }

    public Product getProduct() {
        return product;
    }

    public int getUnits() {
        return units;
    }

    public float getSubTotal(){
        return this.subTotal;
    }

    public float getTaxesTotal() {
        return taxesTotal;
    }

    public void setTaxesTotal(float taxesTotal) {
        this.taxesTotal = taxesTotal;
    }
}
