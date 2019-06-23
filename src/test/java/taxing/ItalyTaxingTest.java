package taxing;

import model.*;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the taxing calculation of each product type
 */
public class ItalyTaxingTest {

    Food foodIta2 = new Food(6, "Pecorino", 8, Country.ITALY);
    Medicine medicine_imported = new Medicine(7, "Sunscreen 50", 18f, Country.FRANCE);
    Book bookAbroad = new Book(1, "Art of War", 20, Country.CHINA);
    Product perfumeImportedExpensive = new Product(12, "Imported bottle of expensive perfume", 47.5f, Country.FRANCE);


    @Test
    public void applyTaxesLocalFoodProducts() {
        TaxingItemPolicy taxingItemPolicy = new ItalyTaxing();
        SaleItem saleItem = new SaleItem(foodIta2, 2);

        float totalTaxes = taxingItemPolicy.applyTaxes(saleItem);
        Assert.assertEquals(totalTaxes, 0.0f, 0);


    }

    @Test
    public void applyTaxesImportedMedicineProducts() {
        TaxingItemPolicy taxingItemPolicy = new ItalyTaxing();
        SaleItem saleItem = new SaleItem(medicine_imported, 5);

        float totalTaxes = taxingItemPolicy.applyTaxes(saleItem);
        Assert.assertEquals(totalTaxes, 4.5f, 0);


    }

    @Test
    public void applyTaxesImportedBookProducts() {
        TaxingItemPolicy taxingItemPolicy = new ItalyTaxing();
        SaleItem saleItem = new SaleItem(bookAbroad , 10);

        float totalTaxes = taxingItemPolicy.applyTaxes(saleItem);
        Assert.assertEquals(totalTaxes, 10f, 0);

    }

    @Test
    public void applyTaxesImportedProducts() {
        TaxingItemPolicy taxingItemPolicy = new ItalyTaxing();
        SaleItem saleItem = new SaleItem(perfumeImportedExpensive , 1);

        float totalTaxes = taxingItemPolicy.applyTaxes(saleItem);
        Assert.assertEquals(totalTaxes, 7.15f, 0);

    }


}