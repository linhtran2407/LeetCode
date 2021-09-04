import java.util.LinkedList;
import java.util.Queue;

public class JumpGameVII {
    /*
    @author: https://leetcode.com/morning_coder/
    @version: Sep 04, 2021

    Runtime and usage info of the solution:
Runtime: 14 ms, faster than 52.98% of Java online submissions for Jump Game VII.
Memory Usage: 45.9 MB, less than 51.69% of Java online submissions for Jump Game VII.
*/


    class Solution {
        public boolean canReach(String s, int minJump, int maxJump) {
            int len = s.length();

            if (s.charAt( len - 1 ) == '1'){
                return false;
            }

            Queue<Integer> q = new LinkedList<>();
            q.offer(0);
            int curr_max = 0; // used to avoid repeated traversal of index

            // bfs
            while (!q.isEmpty()){
                int node = q.poll();

                if (node == len - 1){
                    return true;
                }

                for (int i = Math.max( node + minJump, curr_max); i <= Math.min ( node + maxJump, len - 1); i++){
                    if (s.charAt(i) == '0') {
                        q.offer(i);
                    }
                }

                // update curr_max
                curr_max = Math.min ( node + maxJump, len - 1) + 1;
            }

            return false;
        }
    }
}
