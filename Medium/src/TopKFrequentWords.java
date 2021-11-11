import java.util.*;

public class TopKFrequentWords {

//     Runtime: 5 ms, faster than 83.91% of Java online submissions for Top K Frequent Words.
// Memory Usage: 39.2 MB, less than 76.18% of Java online submissions for Top K Frequent Words.

        public List<String> topKFrequent(String[] words, int k) {
            // build freq map
            Map<String, Integer> map = new HashMap<>();
            Arrays.asList(words).forEach(word -> map.put(word, map.getOrDefault(word, 0) +1));
            
            // define min heap
            // 1. store freq in ascending order
            // 2. alphabetical in reverse order
            // so that least prioritized word is always on the top
            PriorityQueue<String> minHeap = new PriorityQueue<>((a,b) -> map.get(a) == map.get(b)? b.compareTo(a) : map.get(a) - map.get(b));
            
            
            for (String word: map.keySet()){
                minHeap.add(word);
                if (minHeap.size() > k){
                    minHeap.poll();
                }
            }
            
            // get result
            // add in reverse order since this is min heap
            List<String> res = new ArrayList<>();
            while (!minHeap.isEmpty()){
                res.add(0, minHeap.poll());
            }
            
            return res;
        }
            
}
