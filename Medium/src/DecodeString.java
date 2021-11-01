import java.util.*;

class DecodeString {
    public String decodeString(String s) {        
        char[] str = s.toCharArray();
        Stack<String> stack = new Stack<>();
        
        for (char c: str){
            if (!String.valueOf(c).equals("]")){
                stack.push(String.valueOf(c));
                
            } else {
                // start popping out
                String poppedChar = stack.pop();
                List<String> local = new ArrayList<>();
                while (!poppedChar.equals("[")){
                    local.add(poppedChar);
                    // update
                    poppedChar = stack.pop();
                }
                
                // calc the number of times need to dup the substring
                int base = 1;
                int dup = 0;

                while (!stack.isEmpty() && isNumeric(stack.peek())){
                    int digit = Integer.parseInt(stack.pop());
                    dup += base*digit;
                    base *= 10;
                }
                
                // push back to stack in reverse order by (dup-1) times
                for (int d = 0; d < dup; d++){
                    for (int i = local.size()-1; i >= 0; i--){
                        stack.push(local.get(i));    
                    }                    
                }

            }
            
        }
        
        // reverse the result before returning
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()){
            res.append(stack.pop());
        }
        
        return res.reverse().toString();
    }
    
    private static boolean isNumeric(String s){
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}