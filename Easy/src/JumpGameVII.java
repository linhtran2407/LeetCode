public class JumpGameVII {


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
