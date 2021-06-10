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
}
