import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    /*
    @author: Linh Tran
    @version: Jun 24th, 2021

    Runtime and usage info of DFS solution:
    Runtime: 25 ms, faster than 89.57% of Java online submissions for Clone Graph.
    Memory Usage: 38.9 MB, less than 90.14% of Java online submissions for Clone Graph.
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
    public Node cloneGraph(Node node) {
        if (node == null) {return null;}

        // base case: if a node is visited, return its clone
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node clone = new Node(node.val, new ArrayList<Node>());
        visited.put(node, clone);

        for (Node neighbor: node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}
