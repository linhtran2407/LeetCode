import java.util.*;

public class CloneGraph {
    /*
    @author: Linh Tran
    @version: Jun 24th, 2021

    Runtime and usage info of DFS solution:
    Runtime: 25 ms, faster than 89.57% of Java online submissions for Clone Graph.
    Memory Usage: 38.9 MB, less than 90.14% of Java online submissions for Clone Graph.

    Runtime and usage info of BFS solution:
    Runtime: 25 ms, faster than 89.57% of Java online submissions for Clone Graph.
    Memory Usage: 39.2 MB, less than 44.38% of Java online submissions for Clone Graph.
*/

// Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    // store current node as key and its clone as value
    HashMap<Node, Node> visited = new HashMap<>();

    /** DFS solution*/
    public Node cloneGraph_DFS(Node node) {
        if (node == null) {return null;}

        // base case: if a node is visited, return its clone
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node clone = new Node(node.val, new ArrayList<Node>());
        visited.put(node, clone);

        for (Node neighbor: node.neighbors) {
            clone.neighbors.add(cloneGraph_DFS(neighbor));
        }

        return clone;
    }

    /** BFS solution */
    public Node cloneGraph_BFS(Node node) {
        if (node == null) {return null;}

        // store current node as key and its clone as value
        HashMap<Node, Node> visited = new HashMap<>();
        Deque<Node> dq = new ArrayDeque<>();

        // add and clone the first node
        dq.add(node);
        Node clone = new Node(node.val);
        visited.put(node, clone);

        while(!dq.isEmpty()) {
            Node curr = dq.poll();

            for (Node nb: curr.neighbors) {
                if (!visited.containsKey(nb)) {
                    visited.put(nb, new Node(nb.val));
                    dq.add(nb);
                }

                // add cloned neighbors to the current clone node
                Node currClone = visited.get(curr);
                Node currCloneNb = visited.get(nb);
                currClone.neighbors.add(currCloneNb);
            }
        }

        return visited.get(node);
    }
}
