public class LongestSubstringWithoutRepeatingCharacters {

        /*
    @author: Linh Tran
    @version: Jun 17th, 2021

    Runtime and usage info of the first solution:
    Runtime: 2 ms, faster than 99.87% of Java online submissions for Longest Substring Without Repeating Characters.
    Memory Usage: 38.9 MB, less than 82.70% of Java online submissions for Longest Substring Without Repeating Characters.
*/
    // Sliding window - TC: O(N)
    public int lengthOfLongestSubstring(String s) {
        if (s.length() ==0){return 0;}
        int start = 0, end = 0, len = 0;
        int[] frequency = new int[128];

        while (end<s.length()) {
            char currChar = s.charAt(end);
            frequency[currChar]++; // increase frequency each time we meet a char

            while (frequency[currChar] > 1) {
                // push the start index forward until we pass the repeated char
                // so that the substring being considered does not contain
                // repeated char
                char startChar = s.charAt(start++);
                frequency[startChar]--;
            }

            len = Math.max(len, end-start+1);
            end++;
        }

        return len;
    }
}
