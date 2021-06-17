import java.util.HashMap;
import java.util.Map;

public class MinimumSizeSubarraySum {

    /*
    @author: Linh Tran
    @version: Jun 17th, 2021

    Runtime and usage info of the first solution:
    Runtime: 1 ms, faster than 99.97% of Java online submissions for Minimum Size Subarray Sum.
    Memory Usage: 39.3 MB, less than 25.84% of Java online submissions for Minimum Size Subarray Sum.
*/

    public int minSubArrayLen(int target, int[] nums) {
        // TC: O(N)
        int windowStart = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            sum += nums[windowEnd];

            while (sum >= target) {
                // once the sum hits target, record the length of subarray
                // and update the length to be the smallest
                minLen = Math.min(minLen, windowEnd-windowStart+1);
                sum -= nums[windowStart++];
            }
        }

        return minLen != Integer.MAX_VALUE? minLen : 0;
    }

    // Optimized sliding window
    public int lengthOfLongestSubstring2(String s) {
        if (s.length() ==0){return 0;}

        int result = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int start=0, end=0; start<s.length() && end<s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                // we want start index to be the the next index after
                // the index of the repeated char we found
                // but that at least has to be greater from the current
                // start, if any, so that we can consider the remaining chars
                // in the string instead of considering backwards
                start = Math.max(start, map.get(s.charAt(end)) +1);
            }

            map.put(s.charAt(end), end);
            result = Math.max(result, end-start+1);

        }

        return result;
    }
}
