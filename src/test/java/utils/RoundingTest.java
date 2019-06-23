package utils;

import org.junit.Assert;
import org.junit.Test;

public class RoundingTest {

    @Test
    public void testRounding(){
        // Test rounding to *.*5 (rounding up to 0.05 if x>=0.25)
        float input = 1.925f;
        float output = Utils.roundTwoDecimals(input);
        Assert.assertEquals(output, 1.95f, 0);
    }

    @Test
    public void testRoundingToLower(){
        // Test rounding for lower value (flooring)
        float input = 1.924f;
        float output = Utils.roundTwoDecimals(input);
        Assert.assertEquals(output, 1.90f, 0);
    }

    @Test
    public void testRoundingToNoDecimals(){
        // Test rounding resulting in no decimals
        float input = 3.999f;
        float output = Utils.roundTwoDecimals(input);
        Assert.assertEquals(output, 4f, 0);
    }

}