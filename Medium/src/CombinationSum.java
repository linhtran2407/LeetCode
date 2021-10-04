import java.util.*;

public class CombinationSum {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        backtrack(candidates, target, start, new LinkedList<Integer>());
        return res;
    }

    private void backtrack(int[] candidates, int remain, int start, LinkedList<Integer> comb) {

    }
}
