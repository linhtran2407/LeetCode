import java.util.*;

// Runtime: 3 ms, faster than 96.18% of Java online submissions for Simplify Path.
// Memory Usage: 39.3 MB, less than 55.58% of Java online submissions for Simplify Path.

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] strings = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String s: strings){
            // empty string (multiple slashes) or dot -> ignore
            if (s.equals(".") || s.isEmpty()){
                continue;
            } else if (s.equals("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        
        StringBuilder simplifiedPath = new StringBuilder();
        for (String dir: stack){
            simplifiedPath.append("/");
            simplifiedPath.append(dir);
        }
        
        return simplifiedPath.length() == 0? "/" : simplifiedPath.toString();
    }
    
}
