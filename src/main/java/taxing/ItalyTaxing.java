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
     * Products that are exempt from basic sales taxation.
     */
    private static final EnumSet EXEMPT_CATEGORIES = EnumSet.of(Category.MEDICINE, Category.BOOK, Category.FOOD);

    /**
     * Countries exempt from import tax.
     */
    private static final EnumSet EXEMPT_COUNTRIES = EnumSet.of(Country.ITALY);

    /**
     * Applies the taxing scheme of sales + import taxes if applicable for a specific item.
     * @param item List of items to be taxed
     * @return Total tax to pay for the given item
     */
    @Override
    public float applyTaxes(SaleItem item) {
        float totalTaxes = applySaleTax(item);
        totalTaxes = Utils.roundTwoDecimals(totalTaxes);
        totalTaxes += applyImportTax(item);

        return Utils.roundTwoDecimals(totalTaxes);
    }


    /* Returns the sales tax to pay for the givne item, unless it's exempt */
    private float applySaleTax(SaleItem item) {
        Category category = item.getProduct().getCategory();
        return EXEMPT_CATEGORIES.contains(category) ? 0 : item.getSubTotal() * BASIC_SALE_TAX;
    }

    /* Returns the import tax to pay for the givne item, unless it's exempt */
    private float applyImportTax(SaleItem item){
        Country productCountry = item.getProduct().getCountryOfOrigin();
        return EXEMPT_COUNTRIES.contains(productCountry) ? 0 : item.getSubTotal() * IMPORT_TAX;
    }
}
