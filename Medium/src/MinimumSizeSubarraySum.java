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
}
