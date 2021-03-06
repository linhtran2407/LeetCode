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

    /*
        @author: Linh Tran
        @version: Aug 17, 2021

        Runtime and usage info of the solution:
        Runtime: 8 ms, faster than 87.90% of Java online submissions for Shortest Word Distance III.
        Memory Usage: 53 MB, less than 85.79% of Java online submissions for Shortest Word Distance III.
    */


    class Solution {
        public int shortestWordDistance(String[] wordsDict, String word1, String word2) {

            int len = wordsDict.length;
            if (len <= 1){return 0;}

            int res = Integer.MAX_VALUE;
            // pointer when found word1 and word2
            int w1 = -1;
            int w2 = -1;

            // find the match and update res
            for (int i=0; i<len; i++){
                // match word1
                if (wordsDict[i].equals(word1)) {
                    w1 = i;

                    if (w2 != -1){
                        res = Math.min(res, w1-w2);
                    }
                }

                // match word2
                if (wordsDict[i].equals(word2)) {
                    w2 = i;

                    if (w1 != -1 && w2 - w1 != 0){
                        res = Math.min(res, w2-w1);
                    }
                }

            }

            return res;
        }
    }
}
