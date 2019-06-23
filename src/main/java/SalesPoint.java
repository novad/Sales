import model.Sale;
import model.SaleItem;
import taxing.TaxingItemPolicy;

/**
 * Represents the point of sale of the store
 */
public class SalesPoint {

    /**
     * Taxing policy interface for the store
     */
    private TaxingItemPolicy taxingScheme;

    public SalesPoint(TaxingItemPolicy taxingScheme) {
        this.taxingScheme = taxingScheme;
    }


    /**
     * End a sale and calculate subotal, taxes, and total.
     * @param sale Sale to finalize
     * @return Finalized sale
     */
    public Sale finalizeSale(Sale sale){
        float subTotal = 0;
        float totalTaxes = 0;
        float total = 0;

        for(SaleItem item : sale.getShoppingCart()){
            float taxes = this.taxingScheme.applyTaxes(item);
            item.setTaxesTotal(taxes);
            totalTaxes += taxes;

            subTotal += item.getSubTotal();
            total += item.getSubTotal() + taxes;
        }

        sale.setSubTotal(subTotal);
        sale.setTotalTaxes(totalTaxes);
        sale.setTotal(total);

        return sale;
    }


    public void printReceipt(Sale sale, ReceiptGenerator receiptGenerator){
        receiptGenerator.printReceipt(sale);
    }

}
