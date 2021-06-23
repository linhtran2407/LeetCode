import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {

/*
    @author: Linh Tran
    @version: June 6th, 2021
    Runtime and usage info:
    Runtime: 6 ms, faster than 53.30% of Java online submissions for Merge Intervals.
    Memory Usage: 41.3 MB, less than 85.28% of Java online submissions for Merge Intervals.
 */

    public int[][] merge(int[][] intervals)  {
        int[][] result = new int[intervals.length][2];

        int index = 0;
        // 1. sort based on the starting point --> O (N log N)
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        // 2. loop and check each neighboring interval for overlap --> O(N)
        int[] currItv = intervals[0];
        for (int i=1; i<intervals.length; i++){
            int[] nextItv = intervals[i];
            if (doesOverlap (currItv, nextItv)) {
                // if overlaps, update currItv
                currItv[1] = Math.max(currItv[1], nextItv[1]);
            } else {
                // add the merged intervals or the interval that does not overlap
                // with its neighbor to the result array
                result[index++] = currItv;
                // update the current interval
                currItv = nextItv;
            }
        }
        // to not miss the last interval
        result[index] = currItv;

        int[][] finalRes = new int[index+1][2];
        for (int i=0; i<=index;i++){
            finalRes[i] = result[i];
        }
        return finalRes;
    }

    private boolean doesOverlap(int[] itv1, int[] itv2){
        // max start <= min end
        return (Math.max(itv1[0], itv2[0]) <= Math.min(itv1[1], itv2[1]));
    }

    /** Alternative solution by LeetCode
     public int[][] merge(int[][] intervals)  {
         // Idea: check for overlap of adjacent interval in the list
         // and merge as much as possible

         // 1. sort array based on starting point: O(nlogn)
         Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

         // Use linked list because we always add to the end, which is easy
         // to do with LL
         LinkedList<int[]> merged = new LinkedList<>();

         // 2. loop and check neighboring interval: O(n)
         for (int[] interval: intervals) {
         // if empty or not overlap
             if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
             } else { // if overlap
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
             }
         }

         return merged.toArray(new int[merged.size()][2]);
     }
     */

}
