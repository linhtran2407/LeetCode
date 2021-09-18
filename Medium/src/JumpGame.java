public class JumpGame {

    class Solution {
        public boolean canJump(int[] nums) {
            // greedy
            // check from the end to see if at each index, we can reach the furthest current index
            int lastPosition = nums.length-1;
            for (int i = nums.length-1; i >= 0; i--){
                if (i + nums[i] >= lastPosition){
                    lastPosition = i;
                }
            }

            return lastPosition == 0;
        }
    }
}
