public class ValidPalindrome {
/*
    @author: Linh Tran
    @version: June 7th, 2021
    Runtime and usage info:
    Runtime: 3 ms, faster than 66.76% of Java online submissions for Valid Palindrome.
    Memory Usage: 40.1 MB, less than 25.42% of Java online submissions for Valid Palindrome.
 */

    public boolean isPalindrome1(String s) {
        for (int i=0, j=s.length()-1; i<j; i++, j--) {
            while ( i < j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(i<j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
        }

        return true;
    }

    /*
    Runtime: 32 ms, faster than 14.13% of Java online submissions for Valid Palindrome.
    Memory Usage: 43.7 MB, less than 5.01% of Java online submissions for Valid Palindrome.
     */
    public boolean isPalindrome2(String s) {
        // 1. clean the string: O(N)
        s = s.replaceAll("[^a-zA-Z0-9]", "");

        // 2. check equality using 2 pointers low and high
        int i = 0;
        int j = s.length()-1;
        while(i<j) {
            if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))){
                i++;
                j--;
            } else {
                return false;
            }
        }

        return true;
    }
}
