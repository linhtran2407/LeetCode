import java.util.*;

/**
 * Problem:
 * You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges
 * where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.
 *
 * Return true if the edges of the given graph make up a valid tree, and false otherwise.
 *
 * Example 1:
 * Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
 * Output: true
 *
 * Example 2:
 * Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
 * Output: false (because there is a cycle)
 *
 * Example 3:
 * Input: n = 5, edges = [[0, 1],[1, 2],[3, 4]]
 * OutputL false (because 2 nodes 3 and 4 are not connected to the remaining tree - i.e can't be visited from 0)
 *
 * Constraints:
     * 1 <= 2000 <= n
     * 0 <= edges.length <= 5000
     * edges[i].length == 2
     * 0 <= ai, bi < n
     * ai != bi
     * There are no self-loops or repeated edges.
 */

public class GraphValidTree {

    /*
    @author: Linh Tran
    @version: July 04, 2021

    Runtime and usage info of the first solution:
    Runtime: 5 ms, faster than 35.43% of Java online submissions for Graph Valid Tree.
    Memory Usage: 39.9 MB, less than 37.43% of Java online submissions for Graph Valid Tree.
*/


    public boolean validTree_1(int n, int[][] edges) {
        // valid tree means:
        // 1. connect: must be able to visit all node starting from 0
        // 2. no cycle: must not visit a node twice


        /** iterative DFS algo:
         * build a adjacency list with node being the key and its neighbor list as the value
         * traverse through all nodes and its children, mark visited
         * if go to a node already visited, return false (cycle detected)
         * count the number of nodes visited starting from root
         * if the count is not the same as n, return false
         *
         * TC: O(|V|+|E|) with V being the number of nodes and E being the number of edges
         * SC: O(|V|+|E|)
         *
         * The iterative BFS algorithm uses the exactly same code, just different data
         * structure (change stack in DFS into a queue (linked list) in BFS)
         */

        List<List<Integer>> adjList = new ArrayList<>();
        // initialize each node with an empty adjacency list
        for (int i = 0; i < n; i++) {
            adjList.add(i, new ArrayList<Integer>());
        }

        // build the adjacency list
        for (int[] e : edges) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }

        // keep track of the parent and visited node
        Map<Integer, Integer> parent = new HashMap<>();
        parent.put(0, -1); // 0 does not have parent, so put -1 in

        // stack that helps traverse all the nodes
        Stack<Integer> st = new Stack<>();
        st.push(0);

        while (!st.isEmpty()) {
            int node = st.pop();

            for (int nei : adjList.get(node)) {
                // ignore if the neighbor is the node's parent
                // because this is an undirected graph
                // and traversing both ways between 2 nodes is acceptable
                if (parent.get(node) == nei) {
                    continue;
                }

                // otherwise, if the neighbor is not the node's parent
                // but we still see it twice -> there is a cycle
                // hence parent map is also a "visited" map
                if (parent.containsKey(nei)) {
                    return false;
                }

                // if not fall into 2 cases above, push the neighbor
                // into stack to continue traversing
                st.push(nei);
                // and mark the neighbor as visited
                parent.put(nei, node);
            }
        }

        return parent.size() == n;
    }

    public boolean validTree_2(int n, int[][] edges) {
        // algo using advanced graph theory:
        // the theory is: if number of edges < n-1, the tree is disconnected
        // if number of edges > n-1, it possibly means the tree contains cycle

        // there are 4 possible cases of tree:
        // 1. not connected, no cycle: number of edges < n-1
        // 2. connected, cycle: number of edges > n-1
        // 3. not connected, cycle
        // 4. connect, no cycle (valid case)

        // case 1 and 2 can be covered by checking the length of edges list
        // case 3 and 4 needs to be checked by either:
        // a, checking connectivity
        // b, checking for cycle
        // if there is a cycle/no connectivity, it must fall into case 3
        // if there is no cycle/connectivity, it must be a valid tree (case 4)
        // checking for cycle might require topological sort, which is costly
        // because runtime is O(|V|+|E|). instead, checking for connectivity
        // requires O(|E|*2) = O(|E|) because we have compare number of edges vs n-1
        // so at worst the number of edges (E) cannot exceed N

        // again, as the first solution, this solution if using DFS, we just need
        // to change the data structure being used: from queue to stack

        // TC: O(|V|)
        // SC: O(|V|)

        if (edges.length != n-1) {return false;}

        List<List<Integer>> adjList = new ArrayList<>();
        // initialize each node with an empty list of neighbors
        for (int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }

        // build the adjacency list
        for (int[] e: edges){
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }

        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(0);
        Set<Integer> seen = new HashSet<>();
        seen.add(0);

        while(!dq.isEmpty()){
            int node = dq.poll();
            for (int nei: adjList.get(node)){
                if(seen.contains(nei)){continue;}
                seen.add(nei);
                dq.add(nei);
            }
        }

        return seen.size() == n;
    }
}
