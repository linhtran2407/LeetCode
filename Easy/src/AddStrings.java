public class AddStrings {
/*
    @author: Linh Tran
    @version: June 5, 2021
    Runtime and usage info:
    Runtime: 2 ms, faster than 91.80% of Java online submissions for Add Strings.
    Memory Usage: 39.1 MB, less than 48.14% of Java online submissions for Add Strings.

    Solution was modified after I reviewed solution by LeetCode.
 */

    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        int carry = 0;
        while (n1 >= 0 || n2 >= 0) {
            int x1 = n1 >= 0 ? num1.charAt(n1) - '0' : 0;
            int x2 = n2 >= 0 ? num2.charAt(n2) - '0' : 0;
            int temp = (x1 + x2 + carry) % 10;
            carry = (x1 + x2 + carry) / 10;
            res.append(temp);
            n1--;
            n2--;
        }

        if (carry != 0) {
            res.append(carry);
        }
        return res.reverse().toString();
    }
}
