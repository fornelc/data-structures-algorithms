package com.algorithms.datastructures;

public class StringToInteger {

    /**
     * We have to build numerical value by repeatedly shifting the result to left by one digit
     * and adding the next number at the unit place. Since numerical value is a decimal number
     * represented as base 10 in the number system,
     * each digit can be expressed as multiples of powers of 10.
     *
     * Example - "142" can be represented as 1 * (10^2) + 4 * (10^1) + 2 * (10^0)
     *
     * This can be formulated as :
     * result * 10 + (str[i] - '0')
     *
     * Solution explained: https://leetcode.com/problems/string-to-integer-atoi/solution/
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        int i = 0;
        int sign = 1;
        int result = 0;
        if (str.length() == 0) return 0;

        //Discard whitespaces in the beginning
        while (i < str.length() && str.charAt(i) == ' ')
            i++;

        // Check if optional sign if it exists
        if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-'))
            sign = (str.charAt(i++) == '-') ? -1 : 1;

        // Build the result and check for overflow/underflow condition
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (str.charAt(i++) - '0');
        }
        return result * sign;

    }
}
