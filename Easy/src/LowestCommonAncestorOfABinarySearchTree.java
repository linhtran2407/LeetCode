import java.util.ArrayDeque;
import java.util.Deque;

public class LowestCommonAncestorOfABinarySearchTree {
/*
    @author: Linh Tran
    @version: July 05, 2021

    Runtime and usage info of DFS solution:
    Runtime: 3 ms, faster than 100.00% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
    Memory Usage: 40.1 MB, less than 31.37% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
*/

     // Definition for a binary tree node.
     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }

    public TreeNode lowestCommonAncestor_DFS(TreeNode root, TreeNode p, TreeNode q) {
        // BST: left < root < right
        // --> find the point where p <= root <= q || p >= root >= q
        // in other case, either root < p, q --> go right subtree
        // or p, q < root --> go left subtree

        // TC: O(N)

        if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestor_DFS(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val){
            return lowestCommonAncestor_DFS(root.right, p, q);
        } else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestor_BFS(TreeNode root, TreeNode p, TreeNode q) {
        // TC: worst - O(N), balanced tree: O(logN)

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);

        while(!dq.isEmpty()){
            TreeNode curr = dq.poll();

            if(p.val < curr.val && q.val < curr.val){
                if (curr.left != null){dq.add(curr.left);}
            } else if (p.val > curr.val && q.val > curr.val){
                if (curr.right != null){dq.add(curr.right);}
            } else {
                return curr;
            }
        }

        return null;
    }
}
