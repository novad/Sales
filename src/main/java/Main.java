import model.ProductDummies;
import model.Sale;
import taxing.ItalyTaxing;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    /**
     * Execute and print the 3 test cases.
     */
    public static void main(String[]args){
        SalesPoint salesPoint = new SalesPoint(new ItalyTaxing());



        Sale newSale = new Sale(sdf.format(new Date()));
        newSale.addPurchase(ProductDummies.bookItaly, 2);
        newSale.addPurchase(ProductDummies.musicCD, 1);
        newSale.addPurchase(ProductDummies.chocolateBarLocal, 1);

        Sale sale = salesPoint.finalizeSale(newSale);
        salesPoint.printReceipt(sale, new ConcreteRecepitGenerator());



        Sale newSale1 = new Sale(sdf.format(new Date()));
        newSale1.addPurchase(ProductDummies.chocolateImported, 1);
        newSale1.addPurchase(ProductDummies.perfumeImportedExpensive, 1);

        Sale sale1 = salesPoint.finalizeSale(newSale1);
        salesPoint.printReceipt(sale1, new ConcreteRecepitGenerator());


        Sale newSale2 = new Sale(sdf.format(new Date()));
        newSale2.addPurchase(ProductDummies.perfumeImported, 1);
        newSale2.addPurchase(ProductDummies.perfumeLocal, 1);
        newSale2.addPurchase(ProductDummies.medicine, 1);
        newSale2.addPurchase(ProductDummies.chocolateImportedExpensive, 3);

        Sale sale2 = salesPoint.finalizeSale(newSale2);
        salesPoint.printReceipt(sale2, new ConcreteRecepitGenerator());

    }
}
