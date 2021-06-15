import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem:
 *
 * Given an array of integers, return the max sub-array with size of at most K elements
 *
 * Test case 1:
 * int[] A = { 2, 1, -5, 6, 0, -8, 9};
 * int k = 3;
 * --> consider subarrays: [2], [1], ... [9], [2,1], [1,-5], .. [-8,9], ... [2,1,-5], [1,-5,6],... [0,-8,9]
 * --> Answer = 9 (with k = 1 < 3, satisfying the condition of at most K elements)
 */

public class MaxSubArraySumVarySize {

    public static void main (String[] args) {
        int[] A = { 2, 1, -5, -8, 9};
        int k = 3;
        System.out.println(subArraySum(A, k));

        int[] B = {-2, -5, 7};
        int j = 3;
        System.out.println(subArraySum(B, j));

        int[] C = {-20, -5};
        int m = 1;
        System.out.println(subArraySum(C, m));

        int[] D = {-20, -5, -2, -100, -9};
        int n = 2;
        System.out.println(subArraySum(D, n));

        int[] E = {2 ,3, 5, 10, 1, 10};
        int l = 3;
        System.out.println(subArraySum(E, l));

        int[] F = {2 ,3, 5};
        int g = 3;
        System.out.println(subArraySum(F, g));

        int[] G = {6};
        int h = 1;
        System.out.println(subArraySum(G, h));
    }

    private static int subArraySum (int[] A, int k) {
        int result = Integer.MIN_VALUE;

        int[] sum = new int[A.length+1];
        sum[0] = 0; // dummy head
        for (int i = 1; i<=A.length; i++) {
            sum[i] = sum[i-1] + A[i-1];
        }

        // find a number i in the range of [index-k+1, index] s.t.
        // sum[0..i] min, in order for the subarray sum from
        // index i+1 to "index" is the largest
        Deque<Integer> indexOfMinSum = new ArrayDeque<>();
        for (int index=1; index < sum.length; index++) {
            // make sure that the indexOfMinSum only contains the indices in the range
            // of [index-k+1, index]
            while (!indexOfMinSum.isEmpty() && indexOfMinSum.peek() < index-k+1) {
                indexOfMinSum.removeFirst();
            }

            while (!indexOfMinSum.isEmpty() ) {
                int currentCandidate = indexOfMinSum.getLast();
                // if the sum of start to the element before current index is even
                // smaller than the sum from start to the current best candidate where
                // we found the min sum at that point before
                // then the current best candidate is not the best anymore
                // so we remove it
                if (sum[index-1] <= sum[currentCandidate-1]) {
                    indexOfMinSum.removeLast();
                } else {
                    break;
                }
            }

            indexOfMinSum.addLast(index);

            // the first element in the array indexOfMinSum is
            // where the sum from 0 to the element before
            // that index in the array is min
            int currIndexOfMinSum = indexOfMinSum.getFirst();
            int tempResult = getSubArraySum(sum, currIndexOfMinSum, index);
            result = Math.max(result, tempResult);
        }

        return result;
    }

    private static int getSubArraySum(int[] sum, int start, int end) {
        return sum[end] - sum[start-1];
    }
}
