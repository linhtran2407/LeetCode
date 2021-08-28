import java.util.Map;

public class DegreeOfAnArray {

    class Solution {
        public int findShortestSubArray(int[] nums) {

            Map<Integer, int[]> map = new HashMap<>();

            // store first and last and frequency
            for (int i=0; i<nums.length; ++i){
                if (map.containsKey(nums[i])){
                    map.put(nums[i], new int[]{map.get(nums[i])[0], i, map.get(nums[i])[2]+1});
                } else {
                    map.put(nums[i], new int[]{i, i, 1});
                }
            }

            int maxOccurence = Integer.MIN_VALUE;
            int len = Integer.MAX_VALUE;

            // find max occurence and min length of subarray that has the max occurence
            for (int item: map.keySet()){
                int occurence = map.get(item)[2];

                if (maxOccurence < occurence){
                    len = map.get(item)[1] - map.get(item)[0]+1;
                    maxOccurence = occurence;
                } else if (maxOccurence == occurence){
                    len = Math.min(len, map.get(item)[1] - map.get(item)[0]+1);
                }
            }

            return len;
        }
    }
}
