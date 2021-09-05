public class FindTheDuplicateNumber {
    /*
    @author: Linh Tran
    @version: July 02, 2021

    Runtime and usage info of the solution:
    Runtime: 21 ms, faster than 35.63% of Java online submissions for Find the Duplicate Number.
    Memory Usage: 56.9 MB, less than 44.59% of Java online submissions for Find the Duplicate Number.
*/

    class Solution {
        public int findDuplicate(int[] nums) {
            int low = 1;
            int high = nums.length - 1;
            int mid = 0;


            while (low < high){
                mid = low + (high - low) / 2;
                if (isDuplicated(nums, mid)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            return high;
        }

        private boolean isDuplicated (int[] nums, int checkedNum){
            int count = 0;
            for (int num: nums) {
                if ( num <= checkedNum){
                    count++;
                }
            }

            return count > checkedNum;
        }
    }
}
