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

        int temp1 = nums[nums.length-1];
        ans[nums.length-2] = temp1;

        for (int i=nums.length-2; i>0; i--){
            temp1 *= nums[i];
            ans[i-1] = temp1;
        }

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
}
