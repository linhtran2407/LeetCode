import java.util.*;

// Runtime: 20 ms, faster than 60.79% of Java online submissions for Design A Leaderboard.
// Memory Usage: 39 MB, less than 83.74% of Java online submissions for Design A Leaderboard.

class Leaderboard {
    // hashmap: addScore + reset in O(1)
    // heap sort k top entries: O(KlogN)
        Map<Integer, Integer> scores;
    
        public Leaderboard() {
            scores = new HashMap<>();
        }
        
        public void addScore(int playerId, int score) {
            if (!scores.containsKey(playerId)){
                scores.put(playerId, 0);
            }
            scores.put(playerId, scores.get(playerId)+score);
        }
        
        public int top(int K) {
            PriorityQueue<Integer> topK = new PriorityQueue<>((a, b) -> a-b);
            
            for (Integer value: scores.values()){
                topK.offer(value);
                
                if (topK.size() > K){
                    // if more than K value, remove 
                    topK.poll();
                }
            }
            
            // take the sum of top K
            Iterator heapItr = topK.iterator();
            int sum = 0;
            while (heapItr.hasNext()){
                sum += (int)heapItr.next();
            }
            return sum;
        }
        
        public void reset(int playerId) {
            scores.remove(playerId);
        }
    }
    
    /**
     * Your Leaderboard object will be instantiated and called as such:
     * Leaderboard obj = new Leaderboard();
     * obj.addScore(playerId,score);
     * int param_2 = obj.top(K);
     * obj.reset(playerId);
     */