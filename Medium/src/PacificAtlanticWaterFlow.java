import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
@author: Linh Tran
@version: July 08, 2021

Runtime and usage info of DFS solution:
Runtime: 4 ms, faster than 81.29% of Java online submissions for Pacific Atlantic Water Flow.
Memory Usage: 40.5 MB, less than 42.50% of Java online submissions for Pacific Atlantic Water Flow.
*/

public class PacificAtlanticWaterFlow {

    // DFS solution
    // TC: O(M*N) with M,N being the size of the graph
    // SC: O(M*N) with M,N being the size of the graph

    class Solution {
        private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        private int m; // number of rows
        private int n; // number of columns
        private boolean[][] pacificReachable;
        private boolean[][] atlanticReachable;

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            // algo: dfs starting from each point on the edge of the graph
            // if the point's height is greater than or equal to the current height
            // add it to the reachable array
            // traverse through both reachable arrays, if satisfy both arrays, add to the result

            m = heights.length; // numbers of rows
            n = heights[0].length; // number of columns

            pacificReachable = new boolean[m][n];
            atlanticReachable = new boolean[m][n];

            List<List<Integer>> res = new ArrayList<>();

            for (int r=0; r<m; r++){
                dfsReach(heights, r, 0, pacificReachable); // left edge
                dfsReach(heights, r, n-1, atlanticReachable); // right edge
            }

            for (int c=0; c<n; c++){
                dfsReach(heights, 0, c, pacificReachable); // top edge
                dfsReach(heights, m-1, c, atlanticReachable); // bottom edge
            }

            for (int r=0; r<m; r++){
                for (int c=0; c<n; c++){
                    if (pacificReachable[r][c] && atlanticReachable[r][c]){
                        List<Integer> list = Arrays.asList(r, c);
                        res.add(list);
                    }
                }
            }

            return res;
        }


        private void dfsReach(int[][] heights, int r, int c, boolean[][] reachable){
            // mark the current cell as reachable
            reachable[r][c] = true;
            int currHeight = heights[r][c];

            // explore 4 directions
            for (int[] dir: DIRECTIONS){
                int newRow = r+dir[0];
                int newCol = c+dir[1];

                // check validity of new coordinates
                if (newRow<0 || newCol<0 || newRow>=m || newCol>=n){
                    continue;
                }

                // if visited already, skip
                if (reachable[newRow][newCol]){
                    continue;
                }

                int newHeight = heights[newRow][newCol];

                // if the new cell satisfies all requirement, then it's reachable
                if (newHeight >= currHeight){
                    dfsReach(heights, newRow, newCol, reachable);
                }
            }
        }
    }
}
