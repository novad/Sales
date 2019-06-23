import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import taxing.ItalyTaxing;
import utils.Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SalesPointTest {

    // Test products
    Book bookItaly = new Book(0, "The Name of the Rose", 12.49f, Country.ITALY);
    Food chocolateImported = new Food(3, "Imported Chocolate box", 10, Country.GERMANY);
    Food chocolateImportedExpensive = new Food(4, "Imported Chocolate box 2", 11.25f, Country.US);
    Food chocolateBarLocal = new Food(5, "Chocolate bar", 0.85f, Country.ITALY);
    Medicine medicine = new Medicine(8, "Headache Pills", 9.75f, Country.ITALY);
    Product musicCD = new Product(10, "Music CD", 14.99f, Country.ITALY);
    Product perfumeImported = new Product(11, "Imported bottle of perfume", 27.99f, Country.FRANCE);
    Product perfumeImportedExpensive = new Product(12, "Imported bottle of expensive perfume", 47.5f, Country.FRANCE);
    Product perfumeLocal = new Product(13, "Bottle of perfume", 18.99f, Country.ITALY);


    private SalesPoint salesPoint;
    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    @Before
    public void setUp() throws Exception {
        // Set taxing scheme to Italy
        this.salesPoint = new SalesPoint(new ItalyTaxing());
    }

    @Test
    public void givenTest1(){

        Sale newSale = new Sale(sdf.format(new Date()));
        newSale.addPurchase(bookItaly, 2);
        newSale.addPurchase(musicCD, 1);
        newSale.addPurchase(chocolateBarLocal, 1);

        Sale sale = this.salesPoint.finalizeSale(newSale);

        this.salesPoint.printReceipt(newSale, new ConcreteRecepitGenerator());

        Assert.assertEquals(sale.getTotal(), 42.32f, 0);
        Assert.assertEquals(sale.getTotalTaxes(), 1.50f, 0);

    }

    @Test
    public void givenTest2(){

        Sale newSale = new Sale(sdf.format(new Date()));
        newSale.addPurchase(chocolateImported, 1);
        newSale.addPurchase(perfumeImportedExpensive, 1);

        Sale sale = this.salesPoint.finalizeSale(newSale);

        this.salesPoint.printReceipt(newSale, new ConcreteRecepitGenerator());

        Assert.assertEquals(sale.getTotalTaxes(), 7.65f, 0);
        Assert.assertEquals(sale.getTotal(), 65.15f, 0);

    }

    /* TODO: discuss.
     /  There's a discrepancy in this test w.r.t. the given tests:
        > 3 boxes of imported chocolate have an unitary value of 11.25
        > no base sale tax is paid because it's food
        > an import tax of 0.05 has to be paid, so:
            (11.25*3) * 1.05 = 35.4375
          Rounded to closest 0.05:
            35.45
          The given examples stated 35.55
     */
    @Test
    public void givenTest3(){

        Sale newSale = new Sale(sdf.format(new Date()));
        newSale.addPurchase(perfumeImported, 1);
        newSale.addPurchase(perfumeLocal, 1);
        newSale.addPurchase(medicine, 1);
        newSale.addPurchase(chocolateImportedExpensive, 3);

        Sale sale = this.salesPoint.finalizeSale(newSale);

        this.salesPoint.printReceipt(newSale, new ConcreteRecepitGenerator());


        // Check totals
        Assert.assertEquals(sale.getTotalTaxes(), 7.8f, 0);
        Assert.assertEquals(sale.getTotal(), 98.28f, 0);
    }
}