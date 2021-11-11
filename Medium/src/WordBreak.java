public class WordBreak {
        public boolean wordBreak(String s, List<String> wordDict) {
            // dynamic programming solution
            // suppose opt[k] is the substring from start to k (k < len-1) that we know is segmentable
            // return true if the substring [k+1, len) is contained in the word dictionary
            // recurrence:
            // opt[j] defined as true if the string (1, j) can be segmented
            // opt[j] = 
                // true, if (1, j) can be segmented
                // true, if opt[k] = true and (k+1, j) can be segmented for all 1 <= k < len
                // false, otherwise
            
            // TC: O(N^2)
            // SC: O(N)
            
            // build word dict
            Set<String> dict = new HashSet<>();
            dict.addAll(wordDict);
            
            int len = s.length();
            boolean[] opt = new boolean[len+1];
            opt[0] = true; // base case: empty string can be segmented
            
            for (int index = 0; index < len; index++){
                for (int k = 0; k <= index; k++){
                    if (opt[k] && dict.contains(s.substring(k, index+1))){
                        opt[index+1] = true;
                    }
                }
            }
            
            
            return opt[len];
        }
    
}
