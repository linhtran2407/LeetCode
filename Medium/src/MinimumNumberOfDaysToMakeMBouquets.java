public class MinimumNumberOfDaysToMakeMBouquets {
    /*
    @author: Linh Tran
    @version: July 02, 2021

    Runtime and usage info of the solution:
    Runtime: 52 ms, faster than 6.88% of Java online submissions for Minimum Number of Days to Make m Bouquets.
    Memory Usage: 88 MB, less than 15.34% of Java online submissions for Minimum Number of Days to Make m Bouquets.
*/


    class Solution {
        public int minDays(int[] bloomDay, int m, int k) {
            // binary search on the range [smallest num, largest num] in bloomDay array
            // at each search, check if possible by counting the number of adjacent subarrays

            // TC: let M being the largest number in bloomDay (i.e. max at 10^9), TC is
            // O(N*logM) since for each search in binary search, we divide the list into halves
            // of M total values -> logM. for each search, go through the whole array -> N*logM

            int numFlowers = bloomDay.length;
            // not enough flowers to achieve goal
            if (numFlowers < m*k) {return -1;}

            // find range of binary search
            int[] range = findRange(bloomDay, Integer.MAX_VALUE, Integer.MIN_VALUE);
            int min = range[0];
            int max = range[1];

            // binary search
            while (min < max){
                int mid = min + (max - min)/2;

                if (isPossible(bloomDay, mid, m, k)){
                    max = mid;
                } else {
                    min = mid + 1;
                }
            }

            return min;
        }

        private boolean isPossible (int[] bloomDay, int mid, int m, int k){
            int countAdj = 0;
            int countBouquets = 0;

            for (int day: bloomDay){
                if (day <= mid) {
                    countAdj++;

                    // update if enough adjacent flowers to form a bouquet
                    countBouquets = countAdj % k == 0? countBouquets + 1 : countBouquets;
                } else {
                    countAdj = 0;
                }
            }

            return countBouquets >= m;
        }

        private int[] findRange(int[] bloomDay, int min, int max){
            for (int num: bloomDay){
                min = Math.min(min, num);
                max = Math.max(max, num);
            }

            return new int[]{min, max};
        }
    }
}
