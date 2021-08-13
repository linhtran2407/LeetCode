public class ShortestWordDistanceIII {
    /**
     * Problem:
     * Given a list of words and two words word1 and word2, return the
     * shortest distance between these two words in the list.
     * word1 and word2 may be the same and they represent two individual words in the list.
     *
     * Example:
     * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
     *
     * Input: word1 = “makes”, word2 = “coding”
     * Output: 1
     *
     * Input: word1 = "makes", word2 = "makes"
     * Output: 3
     *
     * Note: You may assume word1 and word2 are both in the list.
     */

    https://leetcode.com/problems/shortest-word-distance-iii/discuss/67129/clean-short-fast-Java-solution-in-O(N)-time-and-O(1)-space

    class Solution {
        public int shortestWordDistance(String[] words, String word1, String word2) {
            // idea: go through the array and detect if the current word matches either of the word
            // 1. when it finds the first match (can match either word1 or word2), store that word in
            // a String variable (named firstMatch for example) and that word's index in an integer variable
            // (named firstIndex for example)
            // 2. continue searching through the array until found the second match (again can be word1 or 2)
            // 3. check if:
            // the String firstMatch is not null (this means the first match is found already), AND
            // EITHER (the word found at the 2nd match is not the same as the String firstMatch (for the
            // case when 2 words given are different, say "coding" and "practice")) OR (word1.equals(word2))
            //  is true (for the case when 2 words given are th same)
            // then update the difference
            // 4. reset the firstMatch to be the second match and reset the firstIndex to be the index of
            // the second-match word, so that we can continue searching
            // time complexity: O(M*N) with N being the number of words in the array, and M being the length of each word for the equals() method
            // space complexity: O(1)

            int firstIndex = -1;
            String firstMatch = null;
            int res = Integer.MAX_VALUE;

            for (int i=0; i<words.length; i++){
                // check if there is a match
                if (words[i].equals(word1) || words[i].equals(word2)){
                    // update if there is previous match and the second match is truly
                    // the second match, not the duplicate of the first one
                    if ( firstMatch != null && (word1.equals(word2) || !words[i].equals(firstMatch)) ){
                        res = Math.min(res, i-firstIndex);
                    }

                    // reset the variables, or set new found if there is no previous match yet
                    firstIndex = i;
                    firstMatch = words[i];
                }
            }

            return res;
        }
    }
}
