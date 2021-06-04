public class SubarraySumEqualsK {
/*
    @author: Linh Tran
    @version: Jun 4, 2021
    Runtime and usage info:
    Runtime: 1708 ms, faster than 5.00% of Java online submissions for Subarray Sum Equals K.
    Memory Usage: 51.5 MB, less than 8.39% of Java online submissions for Subarray Sum Equals K.
 */
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i]==k){count++;}
            int sum = nums[i];
            int j = i+1;
            while (j<nums.length) {
                sum += nums[j];
                if (sum == k){count++;}
                j++;
            }
        }
        return count;
    }
}
