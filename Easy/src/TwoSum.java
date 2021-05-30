import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
    Example 1:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Output: Because nums[0] + nums[1] == 9, we return [0, 1].

    Example 2:
    Input: nums = [3,2,4], target = 6
    Output: [1,2]

    Example 3:
    Input: nums = [3,3], target = 6
    Output: [0,1]
     */

    public static void main(String[] args){
        System.out.println(twoSum(new int[]{2,7,11,15}, 9));
        System.out.println(twoSum(new int[]{3,2,4}, 6));
        System.out.println(twoSum(new int[]{3,3}, 6));
    }

    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        // fill the hash table
        for (int i=0; i<nums.length; i++){
            int other = target - nums[i];
            // let the key be the value in the arr,
            // i be the index of that value in the arr
            map.put(nums[i], i);

            if (map.containsKey(other)){
                return new int[]{map.get(other), i};
            }
        }
        return null;
    }
}

