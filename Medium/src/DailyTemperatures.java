import java.util.*;

public class DailyTemperatures {
    public class Pair{
        int val;
        int key;
        public Pair (int key, int val){
            this.val = val;
            this.key = key;
        }

        public int getKey(){
            return this.key;
        }
        public int getValue(){
            return this.val;
        }

    }
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair> stack = new Stack<>();
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
