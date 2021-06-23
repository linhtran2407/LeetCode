import java.math.BigInteger;

public class AddBinary {

/*
    @author: Linh Tran
    @version: Jun 10th, 2021

    Runtime and usage info of the first solution:
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Binary.
    Memory Usage: 37.7 MB, less than 73.27% of Java online submissions for Add Binary.
 */

    public String addBinary(String a, String b) {
        // return directly if either a or b is 0
        if (a.equals("0")) {return b;}
        if (b.equals("0")) {return a;}

        // make sure a is always longer
        if (a.length() < b.length()) {return addBinary(b, a);}

        // string contains result in reverse order
        StringBuilder sb = new StringBuilder();

        int LA = a.length();
        int LB = b.length();
        int j = LB-1;
        int carry = 0;

        for(int i=LA-1; i>=0; i--) {
            if (a.charAt(i) == '1') {carry++;}
            if (j>=0 && b.charAt(j--) == '1') {carry++;}

            if(carry % 2 == 1) {sb.append("1");}
            else {sb.append("0");}

            carry /= 2;
        }

        if (carry == 1){sb.append(carry);}
        return sb.reverse().toString();
    }

    /*
    Follow up question: what if we cannot use addition (+) ?
    Answer: Bit manipulation

    Idea explanation in a well-made vid: https://www.youtube.com/watch?v=qq64FrA2UXQ

    Runtime: 6 ms, faster than 17.82% of Java online submissions for Add Binary.
    Memory Usage: 39 MB, less than 41.62% of Java online submissions for Add Binary.
     */
    public String addBinary_BitManipulation(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger zero = new BigInteger("0", 2); // used to define when carry is 0 or not
        BigInteger sum, carry; // hold the sum without carries and the carries

        while (y.compareTo(zero) != 0) {
            // while there is still carry to move on
            sum = x.xor(y); // xor (^) helps to calculate the sum without carry
            carry = x.and(y).shiftLeft(1); // and (&) helps to calculate the carries

            x = sum;
            y = carry;
        }

        return x.toString(2);
    }

}
