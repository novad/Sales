import model.Sale;
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
        // TODO: implement
        return null;
    }


}
