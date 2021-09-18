public class JumpGame {

        /*
    @author: Linh Tran
    @version: Sep 18th, 2021

    Runtime and usage info:
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Jump Game.
    Memory Usage: 63.7 MB, less than 25.53% of Java online submissions for Jump Game.
 */

    class Solution {
        public boolean canJump(int[] nums) {
            // greedy
            // check from the end to see if at each index, we can reach the furthest current index

            // TC: O(N) for the loop
            // SC: O(1)
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
