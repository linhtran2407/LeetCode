/*
Problem:

Given an array of integers, return the size of the smallest subarray that has the sum >= a specific K
Test case 1:
A = [1,3,6,-4,2], K = 2
--> Answer: 1, because the smallest subarray that is >= 2 is the subarray [2]

Test case 2:
A = [1,3,6,-4,2], K = 4
--> Answer: 1, because the smallest subarray that is >= 4 is the subarray [6]
 */

public class SmallestSubArrayGreaterThanK {
    public static void main (String[] args ) {
        int[] A = {1,3,6,-4,2};
        System.out.println(smallestSubArrayGreaterThanK(A, 4));
        System.out.println(smallestSubArrayGreaterThanK(A, 2));

        int[] B = {1,-4,2,8,2,5};
        System.out.println(smallestSubArrayGreaterThanK(B, 7));
    }

    private static int smallestSubArrayGreaterThanK(int[] A, int k) {
        int smallestSize = Integer.MAX_VALUE;
        int currSum = 0;
        int startIndex = 0;

        for (int endIndex=0; endIndex< A.length; endIndex++) {
            currSum += A[endIndex];

            while (currSum >= k) {
                smallestSize = Math.min(smallestSize, (endIndex - startIndex) +1);
                currSum -= A[startIndex++];
            }

        }

        return smallestSize;
    }
}
