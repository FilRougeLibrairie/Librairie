package utils;

/**
 *
 * @author ggarvanese
 */


public class PriceCalculation {
    
    public static float calculatePriceTTC(float priceHT, float vat){
        return priceHT * (1 + (vat / 100));
    }

    
}
