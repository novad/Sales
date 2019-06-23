package taxing;

import model.SaleItem;

public interface TaxingItemPolicy {
    /**
     * Apply taxes to a sale item
     * @param item Item to be taxed
     */
    float applyTaxes(SaleItem item);
}
