import java.util.*;
// Runtime: 2 ms, faster than 95.62% of Java online submissions for All Paths From Source to Target.
// Memory Usage: 41 MB, less than 58.99% of Java online submissions for All Paths From Source to Target.
public class AllPathsFromSourceToTarget {

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> allPaths = new ArrayList<>();
            if (graph[0].length == 0){
                return allPaths;
            }
            
            LinkedList<Integer> path = new LinkedList<>();
            path.offer(0);
            backtrack (allPaths, path, graph, 0, graph.length-1);
            return allPaths;
        }
        
        private void backtrack(List<List<Integer>> allPaths, LinkedList<Integer> path, int[][] graph, int currNode, int target){
            if (currNode == target){
                allPaths.add(new ArrayList<Integer>(path));
                return;
            }
            
            for (int neighbor: graph[currNode]){
                path.add(neighbor);
                backtrack(allPaths, path, graph, neighbor, target);
                
                path.removeLast();
            }
        }
    
}
