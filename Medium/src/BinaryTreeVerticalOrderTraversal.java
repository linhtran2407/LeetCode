import java.util.*;


public class BinaryTreeVerticalOrderTraversal {
//     Runtime: 2 ms, faster than 93.79% of Java online submissions for Binary Tree Vertical Order Traversal.
// Memory Usage: 39 MB, less than 89.03% of Java online submissions for Binary Tree Vertical Order Traversal.
// TC: O(N) for traversing through all nodes in trees
// SC: O(N) for storing all nodes in columnTable
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
    }

    public class Pair{
        TreeNode key;
        int value;
        public Pair (TreeNode key, int value){
            this.key = key;
            this.value = value;
        }

        public TreeNode getKey(){
            return this.key;
        }

        public int getValue(){
            return this.value;
        }
    }
 
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        
        // build columnTable
        Map<Integer, List<Integer>> columnTable = new HashMap<>();
        
        int[] colRange = buildColTable(columnTable, root);

        for (int col = colRange[0]; col <= colRange[1]; col++){
            List<Integer> listCurrCol = columnTable.get(col);
            res.add(listCurrCol);
        }
        
        return res;
    }
    
    // return the range of column
    private int[] buildColTable (Map<Integer, List<Integer>> columnTable, TreeNode root){
        int minCol = Integer.MAX_VALUE, maxCol = Integer.MIN_VALUE;
        
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair(root,0));
        columnTable.put(0, new ArrayList<>());
        columnTable.get(0).add(root.val);
        
        while (!q.isEmpty()){
            Pair<TreeNode, Integer> curr = q.poll();
            
            int currCol = curr.getValue();
            minCol = Math.min(currCol, minCol);
            maxCol = Math.max(currCol, maxCol);
            
            TreeNode leftChild = curr.getKey().left;
            TreeNode rightChild = curr.getKey().right;
            
            if (leftChild != null){
                columnTable.putIfAbsent(currCol-1, new ArrayList<>());
                columnTable.get(currCol-1).add(leftChild.val);
                q.add(new Pair(leftChild, currCol-1));
            }
            
            if (rightChild != null){
                columnTable.putIfAbsent(currCol+1, new ArrayList<>());
                columnTable.get(currCol+1).add(rightChild.val);
                q.add(new Pair(rightChild, currCol+1));
            }
        }
        
        return new int[]{minCol, maxCol};
    }
    


}
