package utils;

import java.text.DecimalFormat;

public class Utils {

    /**
     * Rounds to the closest 0.05 decimal.
     * Returns the result with 2 decimals.
     *
     * e.g. with input 1.236 the function outputs 1.25
     * @param number Number to format
     * @return Formatted number.
     */
    public static float roundClosestDecimal(float number) {
        float roundedNumber = Math.round(number * 20) / 20.0f;
        return roundTwoDecimals(roundedNumber);
    }

    /**
     * Rounds a given number to 2 decimals
     * @param number Number to round
     * @return Rounded number
     */
    public static float roundTwoDecimals(float number) {
        DecimalFormat formattedNumber = new DecimalFormat("#.##");
        return Float.valueOf(formattedNumber.format(number));
    }}
