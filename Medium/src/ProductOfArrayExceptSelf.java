public class ProductOfArrayExceptSelf {
/*
    @author: Linh Tran
    @version: June 1, 2021
    Runtime and usage info:
    Runtime: 2 ms, faster than 21.17% of Java online submissions for Product of Array Except Self.
    Memory Usage: 56.9 MB, less than 5.18% of Java online submissions for Product of Array Except Self.
 */

    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];

        // temp1 holding product of element to the right of element
        int temp1 = nums[nums.length-1];
        ans[nums.length-2] = temp1;

        for (int i=nums.length-2; i>0; i--){
            temp1 *= nums[i];
            ans[i-1] = temp1;
        }

        // temp2 holding product of element to the left of element
        int temp2 = 1;

        for (int i=0; i<nums.length-1; i++){
            if (i+1 != nums.length-1) {
                temp2 *= nums[i];
                ans[i+1] *= temp2;
            } else {
                ans[nums.length-1] = temp2 *= nums[i];
            }
        }

        return ans;
    }

    /*
    LeetCode solution
    Runtime and usage info:
    Runtime: 2 ms, faster than 21.19% of Java online submissions for Product of Array Except Self.
    Memory Usage: 56.3 MB, less than 6.16% of Java online submissions for Product of Array Except Self.
     */

    public int[] productExceptSelf_Leet(int[] nums) {

        // The length of the input array
        int length = nums.length;

        // The left and right arrays as described in the algorithm
        int[] L = new int[length];
        int[] R = new int[length];

        // Final answer array to be returned
        int[] answer = new int[length];

        // L[i] contains the product of all the elements to the left
        // Note: for the element at index '0', there are no elements to the left,
        // so L[0] would be 1
        L[0] = 1;
        for (int i = 1; i < length; i++) {

            // L[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] would give the product of all
            // elements to the left of index 'i'
            L[i] = nums[i - 1] * L[i - 1];
        }

        // R[i] contains the product of all the elements to the right
        // Note: for the element at index 'length - 1', there are no elements to the right,
        // so the R[length - 1] would be 1
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {

            // R[i + 1] already contains the product of elements to the right of 'i + 1'
            // Simply multiplying it with nums[i + 1] would give the product of all
            // elements to the right of index 'i'
            R[i] = nums[i + 1] * R[i + 1];
        }

        // Constructing the answer array
        for (int i = 0; i < length; i++) {
            // For the first element, R[i] would be product except self
            // For the last element of the array, product except self would be L[i]
            // Else, multiple product of all elements to the left and to the right
            answer[i] = L[i] * R[i];
        }

        return answer;
    }
}
