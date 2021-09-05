public class KthSmallestElementInASortedMatrix {
    class Solution {
        int n;
        public int kthSmallest(int[][] matrix, int k) {
            // binary search:
            // range of the search is within the smallest element in the matrix
            // and the largest element in the matrix
            // at each search, count in the matrix the no. of elements smaller than
            // the hypothetical middle

            // TC: O(N * log (MAX - MIN)) with N being the number of elements in
            // the matrix, MAX being the largest elem and MIN being the smallest elem
            // SC: O(1)

            n = matrix.length;
            int start = matrix[0][0]; // smallest num in matrix
            int end = matrix[n-1][n-1]; // largest num in matrix

            while (start < end){
                int mid = start + (end - start) / 2;
                int[] leftRightPair = new int[]{start, end};

                int count = countLessThanOrEqual(matrix, mid, leftRightPair);
                if (count == k){
                    return leftRightPair[0];
                } else if (count < k) {
                    start = leftRightPair[1]; // search higher
                } else {
                    end = leftRightPair[0]; // search lower
                }
            }

            return start;
        }

        // count the number of elem that are <= mid in the matrix
        private int countLessThanOrEqual (int[][] matrix, int mid, int[] leftRightPair){
            int count = 0;
            // start from the last elem of the first col
            int row = n - 1, col = 0;

            while (row >= 0 && col < n){
                int val = matrix[row][col];

                if (val > mid){
                    // move up the matrix because all elem on the right of this row
                    // are > mid
                    row--;
                    // update smallest number greater than mid
                    leftRightPair[1] = Math.min(val, leftRightPair[1]);
                } else {
                    // move right the matrix to cont. checking next elem in the row
                    col++;
                    // update largest number smaller than mid
                    leftRightPair[0] = Math.max(val, leftRightPair[0]);
                    // update counting
                    count += row + 1;
                }
            }

            return count;
        }
    }
}
