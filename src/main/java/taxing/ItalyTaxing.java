package taxing;

import model.Category;
import model.Country;
import model.SaleItem;
import utils.Utils;

import java.util.EnumSet;

/**
 * Specifies the taxing policy for products sold in Italy
 */
public class ItalyTaxing implements TaxingItemPolicy {

    /**
     * Parameters for this specific taxing scheme
     */
    private static final float BASIC_SALE_TAX  = 0.1f;
    private static final float IMPORT_TAX  = 0.05f;


    /**
     * Applies the taxing scheme of sales + import taxes if applicable for a specific item.
     * @param item List of items to be taxed
     * @return Total tax to pay for the given item
     */
    @Override
    public float applyTaxes(SaleItem item) {
        //TODO: implement
        return 0.0f;
    }


}
