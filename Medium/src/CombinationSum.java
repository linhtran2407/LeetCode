import java.util.*;

import jdk.internal.org.jline.reader.Candidate;

public class CombinationSum {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        backtrack(candidates, target, 0, new LinkedList<Integer>());
        return res;
    }

    private void backtrack(int[] candidates, int remain, int start, LinkedList<Integer> comb) {
        // base case: if reach the target or exceed - i.e. cannot reach the target
        if (remain == 0) {
            // create a deep copy of current combination and add to result
            res.add(new ArrayList<Integer>(comb));
            return;
        } else if (remain < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            comb.add(candidates[i]);
            backtrack(candidates, remain - candidates[i], i, comb);
            //
            comb.removeLast();
        }
    }
}
