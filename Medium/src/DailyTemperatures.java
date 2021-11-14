public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++){
            while (!stack.isEmpty() && stack.peek().getValue() < temperatures[i]){
                int indexRes = stack.pop().getKey();
                res[indexRes] = i - indexRes;
            }
            stack.push(new Pair(i, temperatures[i]));
        }
        
        return res;
    }
}
