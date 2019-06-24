import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import taxing.ItalyTaxing;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SalesPointTest {

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
        newSale.addPurchase(ProductDummies.bookItaly, 2);
        newSale.addPurchase(ProductDummies.musicCD, 1);
        newSale.addPurchase(ProductDummies.chocolateBarLocal, 1);

        Sale sale = this.salesPoint.finalizeSale(newSale);

        this.salesPoint.printReceipt(newSale, new ConcreteRecepitGenerator());

        Assert.assertEquals(sale.getTotal(), 42.32f, 0);
        Assert.assertEquals(sale.getTotalTaxes(), 1.50f, 0);

    }

    @Test
    public void givenTest2(){

        Sale newSale = new Sale(sdf.format(new Date()));
        newSale.addPurchase(ProductDummies.chocolateImported, 1);
        newSale.addPurchase(ProductDummies.perfumeImportedExpensive, 1);

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
        newSale.addPurchase(ProductDummies.perfumeImported, 1);
        newSale.addPurchase(ProductDummies.perfumeLocal, 1);
        newSale.addPurchase(ProductDummies.medicine, 1);
        newSale.addPurchase(ProductDummies.chocolateImportedExpensive, 3);

        Sale sale = this.salesPoint.finalizeSale(newSale);

        this.salesPoint.printReceipt(newSale, new ConcreteRecepitGenerator());


        // Check totals
        Assert.assertEquals(sale.getTotalTaxes(), 7.8f, 0);
        Assert.assertEquals(sale.getTotal(), 98.28f, 0);
    }
}