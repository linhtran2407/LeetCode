public class TargetSum {


    // iterative
    class Solution {
        int count = 0;
        public int findTargetSumWays(int[] nums, int target) {
            dfs(nums,0,0,target);
            return count;
        }

        private void dfs(int[] nums, int index, int sum, int target){
            if (index == nums.length){
                if (sum == target){
                    count++;
                }
            } else {
                dfs(nums, index+1, sum + nums[index], target);
                dfs(nums, index+1, sum - nums[index], target);
            }
        }
    }
}
