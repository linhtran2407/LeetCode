public class WordSearch {
//     Runtime: 103 ms, faster than 62.86% of Java online submissions for Word Search.
// Memory Usage: 37.3 MB, less than 51.62% of Java online submissions for Word Search.
        private char[][] board;
        private int numRows;
        private int numCols;
        
        public boolean exist(char[][] board, String word) {
            this.board = board;
            this.numRows = board.length;
            this.numCols = board[0].length;
            boolean[][] visited  = new boolean[numRows][numCols];
            
            for (int r = 0; r < numRows; r++){
                for (int c = 0; c < numCols; c++){
                    if (dfs(r, c, 0, word, visited)){
                        return true;                        
                    }
                }
            }
            
            return false;
        }
        
        private boolean dfs(int row, int col, int indexChar, String word, boolean[][] visited){
            // base case
            // get to the last char, found all word
            if (indexChar == word.length()){
                return true;
            }
            
            // invalid position or not match char or visited
            if (row < 0 || col < 0 || row >= this.numRows || col >= this.numCols || this.board[row][col] != word.charAt(indexChar) || visited[row][col]){
                return false;
            }
            
            // search for the chars[indexChar] in 4 directions from the current position
            // mark visited before searching to not revisit a cell
            visited[row][col] = true;
            // if each of 4 path is not possible, unmark
            boolean flag = false;
            // left
            flag = flag || dfs(row, col-1, indexChar+1, word, visited);
            if (flag) { // found the path
                visited[row][col] = false;
                return flag;
            }
            
            // right
            flag = flag || dfs(row, col+1, indexChar+1, word, visited);
            if (flag) { // found the path
                visited[row][col] = false;
                return flag;
            }
            
            // up
            flag = flag || dfs(row-1, col, indexChar+1, word, visited);
            if (flag) { // found the path
                visited[row][col] = false;
                return flag;
            }     
            
            // down
            flag = flag || dfs(row+1, col, indexChar+1, word, visited);
            
            visited[row][col] = false;
            
            
            return flag;
        }
        
}
