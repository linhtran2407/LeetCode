import java.util.*;

public class RemoveAllAdjacentDuplicatesInStringII {
    
//     Runtime: 25 ms, faster than 60.84% of Java online submissions for Remove All Adjacent Duplicates in String II.
// Memory Usage: 39.7 MB, less than 73.86% of Java online submissions for Remove All Adjacent Duplicates in String II.

// Runtime: 41 ms, faster than 31.57% of Java online submissions for Remove All Adjacent Duplicates in String II.
// Memory Usage: 39.6 MB, less than 80.37% of Java online submissions for Remove All Adjacent Duplicates in String II.

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

        public String removeDuplicates_stack(String s, int k) {
            StringBuilder sb = new StringBuilder(s);
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < sb.length(); i++){
                // first char or not same as the prev char
                if (stack.isEmpty() || sb.charAt(i) != sb.charAt(i-1)){
                    stack.push(1);
                } else {
                    // same chars
                    int top = stack.pop();
                    stack.push(top+1);
                    if (stack.peek() == k){
                        stack.pop();
                        sb.delete(i-k+1, i+1);
                        i = i - k;
                    }
                }
            }
            
            return sb.toString();
        }
    
}
