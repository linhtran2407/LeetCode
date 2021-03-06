import java.util.*;


// Runtime: 5 ms, faster than 54.25% of Java online submissions for Evaluate Reverse Polish Notation.
// Memory Usage: 38.5 MB, less than 94.00% of Java online submissions for Evaluate Reverse Polish Notation.
public class EvaluateReversePolishNotation {
    
    
        public int evalRPN(String[] tokens) {
            Stack<String> s = new Stack<>();
            for (String t: tokens){
                if (!t.equals("+") && !t.equals("*") && !t.equals("/") && !t.equals("-")){
                    s.push(t);
                    continue;
                }
                
                String operand2 = s.pop();
                String operand1 = s.pop();
                int res = 0;
                if (t.equals("+")){
                    res = Integer.parseInt(operand1) + Integer.parseInt(operand2);
                } else if (t.equals("-")){
                    res = Integer.parseInt(operand1) - Integer.parseInt(operand2);
                } else if (t.equals("*")){
                    res = Integer.parseInt(operand1) * Integer.parseInt(operand2);
                } else if (t.equals("/")){
                    res = (int) (Integer.parseInt(operand1) / Integer.parseInt(operand2));
                }
                
                s.push(String.valueOf(res));
            }
            
            return Integer.parseInt(s.pop());
        }
        
}
