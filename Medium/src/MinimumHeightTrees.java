import java.util.*;

public class MinimumHeightTrees {

        /*
    @author: Linh Tran
    @version: Sep 02, 2021

    Runtime and usage info of the solution:
    Runtime: 84 ms, faster than 8.85% of Java online submissions for Minimum Height Trees.
    Memory Usage: 61.9 MB, less than 5.05% of Java online submissions for Minimum Height Trees.
*/



    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            // algo:
            // apply topological sorting
            // remove all leaves until there are only 2 nodes left - centroids and have the
            // closest distances to all nodes
            // TC: O(|V|+|E|)
            // SC: O(|V|+|E|)

            Map<Integer, Set<Integer>> adjList = new HashMap<>();
            int[] degrees = new int[n];
            buildGraph(n, edges, adjList, degrees);

            // list of leaves
            Queue<Integer> leaves = new LinkedList<>();
            for (int i = 0; i < n; i++){
                if (degrees[i] <= 1){
                    leaves.offer(i);
                }
            }

            int remainingNodes = n;
            while (remainingNodes > 2){
                remainingNodes -= leaves.size();

                Queue<Integer> newLeaves = new LinkedList<>();

                for (int leaf: leaves){
                    for (int nei: adjList.get(leaf)){
                        degrees[nei]--;
                        adjList.get(nei).remove(leaf);

                        if (degrees[nei] == 1){
                            newLeaves.offer(nei);
                        }
                    }
                }

                leaves = newLeaves;

            }


            return (List) leaves;
        }

        private void buildGraph(int n, int[][] edges, Map<Integer, Set<Integer>> adjList, int[] degrees){
            for (int i=0; i<n; i++){
                adjList.put(i, new HashSet<>());
            }

            for (int[] e: edges){
                adjList.get(e[0]).add(e[1]);
                adjList.get(e[1]).add(e[0]);
                degrees[e[0]]++;
                degrees[e[1]]++;
            }
        }
    }
}
