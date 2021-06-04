import java.util.HashMap;

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

    // LeetCode solution:
    // Runtime and usage info:
    // Runtime: 57 ms, faster than 26.89% of Java online submissions for Subarray Sum Equals K.
    // Memory Usage: 58.1 MB, less than 5.00% of Java online submissions for Subarray Sum Equals K.
    public int subarraySum_LeetCode(int[] nums, int k) {
        // store the sum as key and frequencies of those sums as corresponding value
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1); // used to check for case where a single element == k

        int sum = 0;
        int count = 0;
        for (int i = 0; i< nums.length; i++){
            sum += nums[i];
            // if sum[i] - sum[j] = k, then the sum of values lying between ith and jth element is k
            // so we check if there is a sum previously that equals to sum-k
            if (map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            // if a sum exists, increase its value
            // otherwise set value to be default 0
            map.put(sum, map.getOrDefault(sum,0) +1);
        }
        return count;
    }
}
