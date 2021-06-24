public class NumberOfIslands {
    /*
    @author: Linh Tran
    @version: Jun 24th, 2021

    Runtime and usage info of DFS solution:
    Runtime: 1 ms, faster than 99.97% of Java online submissions for Number of Islands.
    Memory Usage: 41.5 MB, less than 55.82% of Java online submissions for Number of Islands.

    Runtime and usage info of BFS solution:
    Runtime: 25 ms, faster than 89.57% of Java online submissions for Clone Graph.
    Memory Usage: 39.2 MB, less than 44.38% of Java online submissions for Clone Graph.
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



}
