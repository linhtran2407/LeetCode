

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
