import java.util.*;

public class GraphValidTree {

    class Solution {
        public boolean validTree(int n, int[][] edges) {
            // valid tree:
            // 1. connect: must be able to visit all node starting from 0
            // 2. no cycle: must not visit a node twice
            // algo:
            // build a adjacency list with node being the key and its neighbor list as the value
            // traverse through all nodes and its children, mark visited
            // if go to a node already visited, return false (cycle detected)
            // count the number of nodes visited starting from root
            // if the count is not the same as n, return false

            // TC: O(|V|+|E|)
            // SC: O(|V|+|E|)

            List<List<Integer>> adjList = new ArrayList<>();
            // initialize each node with an empty adjency list
            for (int i=0; i<n; i++){
                adjList.add(i, new ArrayList<Integer>());
            }

            // build the adjacency list
            for(int[] e: edges){
                adjList.get(e[0]).add(e[1]);
                adjList.get(e[1]).add(e[0]);
            }

            // keep track of the parent and visited node
            Map<Integer,Integer> parent = new HashMap<>();
            parent.put(0, -1); // 0 does not have parent, so put -1 in

            // stack that helps traverse all the nodes
            Stack<Integer> st = new Stack<>();
            st.push(0);

            while(!st.isEmpty()){
                int node = st.pop();

                for (int nei: adjList.get(node)){
                    // ignore if the neighbor is the node's parent
                    // because this is an undirected graph
                    // and traversing both ways between 2 nodes is acceptable
                    if (parent.get(node) == nei){
                        continue;
                    }

                    // otherwise, if the neighbor is not the node's parent
                    // but we still see it twice -> there is a cycle
                    // hence parent map is also a "visited" map
                    if (parent.containsKey(nei)){
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
    }
}
