public class RemoveAllAdjacentDuplicatesInStringII {
    
        public String removeDuplicates(String s, int k) {
    
            StringBuilder sb = new StringBuilder(s);
            int[] counts = new int[s.length()];
            for (int i = 0; i < sb.length(); i++){
                // first char or not same as the prev char
                if (i == 0 || sb.charAt(i) != sb.charAt(i-1)){
                    counts[i] = 1;
                } else {
                    // same chars
                    counts[i] = counts[i-1] + 1;
                    if (counts[i] == k){
                        sb.delete(i-k+1, i+1);
                        i = i - k;
                    }
                }
            }
            
            return sb.toString();
        }
    
}
