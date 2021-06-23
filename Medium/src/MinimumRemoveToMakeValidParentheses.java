import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
    /*
    @author: Linh Tran
    @version: May 31, 2021
    Runtime and usage info:
    Runtime: 771 ms, faster than 5.01% of Java online submissions for Minimum Remove to Make Valid Parentheses.
    Memory Usage: 39.5 MB, less than 74.60% of Java online submissions for Minimum Remove to Make Valid Parentheses.

    (Note: large runtime, small memory usage. see solution from LeetCode below for faster runtime)
 */

    public String minRemoveToMakeValid(String s) {
        char[] c = s.toCharArray(); // O(n)
        char invalid;

        Stack<Character> stack = new Stack<Character>();
        Stack<Integer> invalidIndex = new Stack<Integer>();

        for (int i=0; i<c.length;i++){  // O(2n)
            if (c[i] == '(' ) {
                stack.push(c[i]);
                invalidIndex.push(i);
            } else if (c[i] == ')' ){
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    invalidIndex.pop();
                } else {
                    stack.push(c[i]);
                    invalidIndex.push(i);
                }
            }
        }

        StringBuilder sb = new StringBuilder(s);

        while (!stack.isEmpty() && !invalidIndex.isEmpty()) { // O(2n)
            for (int i=0; i<c.length;i++){
                if (c[i] == stack.peek() && invalidIndex.peek() == i){
                    stack.pop();
                    invalidIndex.pop();
                    sb.deleteCharAt(i);
                    break;
                }
            }
        }
        return sb.toString(); // // O(n)
    }
}


/* LEETCODE SOLUTION:

Runtime: 17 ms, faster than 62.81% of Java online submissions for Minimum Remove to Make Valid Parentheses.
Memory Usage: 39.9 MB, less than 44.53% of Java online submissions for Minimum Remove to Make Valid Parentheses.
Time complexity: O(4n) = O(n)

class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexesToRemove = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    indexesToRemove.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        // Put any indexes remaining on stack into the set.
        while (!stack.isEmpty()) indexesToRemove.add(stack.pop());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexesToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
 */