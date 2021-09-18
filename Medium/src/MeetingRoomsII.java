/*
Problem:

Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
return the minimum number of conference rooms required.

Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2

Example 2:
Input: intervals = [[7,10],[2,4]]
Output: 1

Constraints:
1 <= intervals.length <= 104
0 <= starti < endi <= 106
 */

/*
    @author: https://leetcode.com/supunwijerathne/
    @version: Jun 10th, 2021

    Runtime and usage info of the solution:
    Runtime: 7 ms, faster than 45.40% of Java online submissions for Meeting Rooms II.
    Memory Usage: 38.6 MB, less than 85.80% of Java online submissions for Meeting Rooms II.
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public static int minMeetingRooms(int[][] intervals) {
        // sort the array based on the starting time
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        // sort the queue based on ending time
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (int[] itv : intervals) {
            // if a room is occupied and the ending time of the current meeting in
            // that room is before the starting time of the other meeting
            // then we do not need another room
            if (!pq.isEmpty() && pq.peek()[1] <= itv[0]) {
                pq.poll();
            }
            // otherwise, add new room
            pq.add(itv);
        }

        return pq.size();
    }
}
