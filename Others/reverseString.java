import java.util.*;

/**
 * Given a string of lower-case English letters and paranthesis, reverse all
 * substrings within parentheses and return the string\
 * 
 * 
 */
public class reverseString {
    public static void main(String args[]) {

        /*
         * input = "abc(rab)zab" output = "abcbarzab"
         * 
         * input = "abc(rab(daz))zab" => dazbar output = "abcdazbarzab" explain: -
         * innermost paranthesis has "daz", reverse to be "zad", append back to (rabzad)
         * "(rab(daz))" => rabzad - outter paranthesis has "rabzad", reverse to be
         * "dazbar", append back to the rest "abc(rabzad)zab" => "abcrabzadzab"
         * 
         * pseudocode: use a stack to store the char
         * 
         * iterate through the input if char == ")" initialize a queue pop char out of
         * stack until we meet "(" and append popped out char into the queue poll out
         * and push the char in queue back to stack else push char to the stack
         * 
         * use another stack as a helper to output char in reverse order empty the new
         * stack and append char to stringbuilder and return
         */

        System.out.println(reverse("abc(rab(daz))zab"));
        System.out.println(reverse("abc(rab(daz))(za)b"));

    }

    public static String reverse(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                Queue<Character> q = new LinkedList<>();
                char c = stack.pop();
                while (c != '(') {
                    q.offer(c);

                    // update
                    c = stack.pop();
                }

                while (!q.isEmpty()) {
                    stack.push(q.poll());
                }
            } else {
                stack.push(s.charAt(i));
            }
        }

        Stack<Character> helper = new Stack<>();
        while (!stack.isEmpty()) {
            helper.push(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (!helper.isEmpty()) {
            sb.append(helper.pop());
        }

        return sb.toString();
    }

}
