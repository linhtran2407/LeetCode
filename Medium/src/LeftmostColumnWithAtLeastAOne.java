public class LeftmostColumnWithAtLeastAOne {

/*
    @author: Linh Tran
    @version: June 6th, 2021
    Runtime and usage info:
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Leftmost Column with at Least a One.
    Memory Usage: 39.8 MB, less than 20.14% of Java online submissions for Leftmost Column with at Least a One.

    Runtime complexity: O(N logM) with N being the number of rows and M being the number of columns in the worst case
    *Note: the code cannot be run directly because the BinaryMatrix's API interface is given in the problem.
 */

    /**
     * // This is the BinaryMatrix's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface BinaryMatrix {
     *     public int get(int row, int col) {}
     *     public List<Integer> dimensions {}
     * };
     */

    /**
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int rows = binaryMatrix.dimensions().get(0);
        int cols = binaryMatrix.dimensions().get(1);

        int result = cols;

        for (int i=0; i<rows; i++){
            int low = binarySearch(binaryMatrix, i, cols);
            // check if the value at low index is 1
            // and replace the result with the smallest low
            if (binaryMatrix.get(i, low) == 1 && low<=result){
                result = low;
                // narrow down the number of items in each row for the
                // next binary search, in other words, in the next row,
                // if an 1 exists at the larger index than the current
                // 1 being found in prev row, we skip it.
                cols = low+1;
            }
        }
        // if the result does not change, there is no 1 found
        if (result == cols) {return -1;}
        return result;
    }

    // binary search on each row of the matrix to find the leftmost index of 1
    private int binarySearch (BinaryMatrix binaryMatrix, int row, int cols){
        int low = 0;
        int high = cols-1;
        while (low < high){
            int middle = low + (high-low)/2;
            // if the middle value is 0, search on the right
            if (binaryMatrix.get(row, middle) == 0){
                low = middle+1;
            // if the middle value is 1, continue searching on the left
            // to find the leftmost 1 (if any)
            } else {
                high = middle;
            }
        }

        return low;
    }
     */
}
