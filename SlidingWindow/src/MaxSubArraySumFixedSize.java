/**
 * Problem:
 *
 * Given an array of integers, return the largest sum of k elements (k is fixed)
 */

public class MaxSubArraySumFixedSize {
    public static void main(String[] args) {
        int[] A = { 2, 1, -5, 6, 0, 8, 9};
        int k = 3;
        System.out.println(subArraySum(A, k));
    }

    private static int subArraySum(int[] A, int k) {
        int largestSum = Integer.MIN_VALUE;
        int currSum = 0;

        for (int i = 0; i < A.length; i++) {
            currSum += A[i];
            if (i >= k-1) {
                largestSum = Math.max(currSum, largestSum);
                currSum -= A[i-k+1];
            }
        }

        return largestSum;
    }
}
