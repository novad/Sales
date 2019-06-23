package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a transaction at the store.
 * Consists of the final list of items sold, and the totals that will be computed when the sale is finalized.
 */
public class Sale {
    private String saleDate;
    private List<SaleItem> shoppingCart;
    private float subTotal;     // products * quantity
    private float totalTaxes;   // subTotal * taxes%
    private float total;        // subTotal + taxes

    public Sale(String saleDate) {
        this.saleDate = saleDate;
        this.shoppingCart = new ArrayList<>();
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void addPurchase(Product newProduct, int units){
        SaleItem item = new SaleItem(newProduct, units);
        this.shoppingCart.add(item);
    }

    public List<SaleItem> getShoppingCart() {
        return shoppingCart;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setTotalTaxes(float totalTaxes) {
        this.totalTaxes = totalTaxes;
    }

    public float getTotalTaxes() {
        return totalTaxes;
    }
}
