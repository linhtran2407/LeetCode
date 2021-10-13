import java.util.*;

/*
     * @author: Linh Tran
     * 
     * @version: Sep 26th, 2021
     */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                // found the rightmost not-nine
                digits[i]++;
                return digits;
            }
        }

        digits = new int[n + 1];
        digits[0] = 1;

        return digits;
    }
}