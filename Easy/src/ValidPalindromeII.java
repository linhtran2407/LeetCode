public class ValidPalindromeII {

    /*
    @author: Linh Tran
    @version: Jun 4, 2021
    Runtime and usage info:
    Runtime: 9 ms, faster than 19.21% of Java online submissions for Valid Palindrome II.
    Memory Usage: 51.6 MB, less than 6.31% of Java online submissions for Valid Palindrome II.
 */

    public boolean validPalindrome(String s) {
        if (s.length() <=1) return true;
        int i=0;
        int j= s.length()-1;
        int count = 0;
        return isPalindrome(s, i, j, count);
    }

    private boolean isPalindrome (String s, int i, int j, int count){
        while(i<j){
            if (s.charAt(i) != s.charAt(j)){
                if (count == 1) {
                    return false;
                } else {
                    count++;
                }
                return (isPalindrome(s, i+1, j,count) || isPalindrome(s,i,j-1,count));
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

}
