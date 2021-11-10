class ReverseSubStringsBetweenEachPairOfParantheses {
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if (curr == ')'){
                char popped = stack.pop();
                ArrayList<Character> list = new ArrayList<>();
                while (popped != '('){
                    list.add(popped);
                    popped = stack.pop();
                }
                // push back in reverse ord
                for (char c: list){
                    stack.push(c);
                }
            } else {
                stack.push(curr);
            }
        }
        
        StringBuilder sbRes = new StringBuilder();
        while (!stack.isEmpty()){
            sbRes.append(stack.pop());
        }
        
        return sbRes.reverse().toString();
    }
}