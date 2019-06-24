import model.Sale;
import model.SaleItem;

public class ConcreteRecepitGenerator implements ReceiptGenerator {
    @Override
    public void printReceipt(Sale sale) {

        System.out.println("===================================");
        System.out.println("Receipt of sale - " + sale.getSaleDate());
        System.out.println("===================================");
        for(SaleItem item : sale.getShoppingCart()){
            float totalPrizeItem = item.getSubTotal()+item.getTaxesTotal();
            System.out.println(" - " +
                    item.getUnits() + "x" +
                    item.getProduct().getName() +
                    ": " + totalPrizeItem );
        }
        System.out.println();
        System.out.println("Total Taxes: " + sale.getTotalTaxes());
        System.out.println("Total: " + sale.getTotal());
        System.out.println("===================================");
    }
}
