public class FindTheDuplicateNumber {
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
