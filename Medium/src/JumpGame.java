public class JumpGame {

    class Solution {
        public boolean canJump(int[] nums) {
            // greedy
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
