public class JumpGame {

    class Solution {
        public boolean canJump(int[] nums) {
            // greedy
            // check from the end to see if at each index, we can reach the furthest current index
            int lastPosition = nums.length-1;
            for (int i = nums.length-1; i >= 0; i--){
                // if from i can reach the last position
                if (i + nums[i] >= lastPosition){
                    // update the last position to i to cont. checking prev element
                    lastPosition = i;
                }
            }

            // true if can go back to the first index
            return lastPosition == 0;
        }
    }
}
