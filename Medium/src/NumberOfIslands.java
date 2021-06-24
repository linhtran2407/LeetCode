import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    /*
    @author: Linh Tran
    @version: Jun 24th, 2021

    Runtime and usage info of DFS solution:
    Runtime: 1 ms, faster than 99.97% of Java online submissions for Number of Islands.
    Memory Usage: 41.5 MB, less than 55.82% of Java online submissions for Number of Islands.

    Runtime and usage info of BFS solution:
    Runtime: 4 ms, faster than 21.07% of Java online submissions for Number of Islands.
    Memory Usage: 41.3 MB, less than 66.47% of Java online submissions for Number of Islands.
*/

    /** DFS solution */
    public int numIslands_DFS(char[][] grid) {
        // O(N*M)
        // traverse the whole grid, if found an "1", trigger dfs around it
        // and increase count
        // if found another "1" around, turn to "0" to marked as "visited"
        // if not found, return

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for (int row=0; row<rows; row++) {
            for (int col=0; col<cols; col++) {
                if (grid[row][col] == '1') {
                    count++;
                    dfs(grid, row, col);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row<0 || row>= grid.length || col<0 || col>= grid[0].length || grid[row][col] == '0') {
            return;
        }

        // mark as visited
        grid[row][col] = '0';

        dfs(grid, row-1, col);
        dfs(grid, row+1, col);
        dfs(grid, row, col+1);
        dfs(grid, row, col-1);
    }

    /** BFS solution */
    public int numIslands_BFS(char[][] grid) {
        // O(N*M)
        // Linear scan the 2d grid map, if a node contains a '1', then it is a root node that triggers a Breadth First Search. Put it into a queue and set its value as '0' to mark as visited node. Iteratively search the neighbors of enqueued nodes until the queue becomes empty.

        Queue<int[]> neighbors = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    grid[r][c] = '0'; // mark as visited
                    neighbors.add(new int[]{r, c}); // put into the queue
                }

                while (!neighbors.isEmpty()) {
                    int[] curr = neighbors.remove();
                    int currRow = curr[0];
                    int currCol = curr[1];

                    if (currRow>0 && grid[currRow-1][currCol] == '1') {
                        grid[currRow-1][currCol] = '0';
                        neighbors.add(new int[]{currRow-1, currCol});
                    }

                    if (currRow<rows-1 && grid[currRow+1][currCol] == '1') {
                        grid[currRow+1][currCol] = '0';
                        neighbors.add(new int[]{currRow+1, currCol});
                    }

                    if (currCol>0 && grid[currRow][currCol-1] == '1') {
                        grid[currRow][currCol-1] = '0';
                        neighbors.add(new int[] {currRow, currCol-1});
                    }

                    if (currCol<cols-1 && grid[currRow][currCol+1] == '1') {
                        grid[currRow][currCol+1] = '0';
                        neighbors.add(new int[] {currRow, currCol+1});
                    }
                }
            }
        }

        return count;
    }
}
