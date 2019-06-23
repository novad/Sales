import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import taxing.ItalyTaxing;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SalesPointTest {

    // Test products
    Book bookItaly = new Book(0, "The Name of the Rose", 12.49f, Country.ITALY);
    Book bookSolitude = new Book(1, "One Thousand Years of Solitude", 20, Country.ITALY);
    Book bookQuixote = new Book(2, "Don Quixote", 17, Country.SPAIN);
    Food chocolateImported = new Food(3, "Imported Chocolate box", 10, Country.GERMANY);
    Food chocolateBarLocal = new Food(4, "Chocolate bar", 0.85f, Country.ITALY);
    Food foodIta2 = new Food(5, "Pecorino", 8, Country.ITALY);
    Medicine medicine_imported = new Medicine(6, "Sunscreen 50", 18f, Country.FRANCE);
    Medicine medicine = new Medicine(7, "Headache Pills", 9.75f, Country.ITALY);
    Product musicCD = new Product(9, "Music CD", 14.99f, Country.ITALY);
    Product perfumeImported = new Product(10, "Imported bottle of perfume", 47.5f, Country.FRANCE);
    Product perfumeLocal = new Product(11, "Bottle of perfume", 18.99f, Country.ITALY);


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
        newSale.addPurchase(perfumeImported, 1);

        Sale sale = this.salesPoint.finalizeSale(newSale);

        this.salesPoint.printReceipt(newSale, new ConcreteRecepitGenerator());

        Assert.assertEquals(sale.getTotalTaxes(), 7.65f, 0);
        Assert.assertEquals(sale.getTotal(), 65.15f, 0);

    }
}