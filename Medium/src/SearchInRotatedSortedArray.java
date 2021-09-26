class SearchInRotatedSortedArray {

    /*
     * @author: Linh Tran
     * 
     * @version: Sep 26th, 2021
     * 
     * Runtime and usage info:
     * 
     * Runtime: 2 ms, faster than 6.96% of Java online submissions for Search in
     * Rotated Sorted Array. Memory Usage: 38 MB, less than 92.44% of Java online
     * submissions for Search in Rotated Sorted Array.
     */

    // using 2 binary search
    // 1 to find the rotation index
    // 2 to find the target
    // TC: O(logN)
    // SC: O(1)

    int[] nums;
    int target;

    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        int n = nums.length - 1;
        if (n == 0) {
            return this.nums[0] == target ? 0 : -1;
        }

        int rotationIndex = breakPoint(0, n);
        System.out.println(rotationIndex);
        if (target == nums[rotationIndex]) {
            return rotationIndex;
        }

        // if not rotated
        if (rotationIndex == 0) {
            return search(0, n);
        }

        // if is rotated
        if (target > nums[n]) {
            // search on left of rotation index
            return search(0, rotationIndex - 1);
        }

        return search(rotationIndex, n);

    }

    private int search(int start, int end) {
        while (start <= end) {
            int pivot = start + (end - start) / 2;
            if (nums[pivot] == target) {
                return pivot;
            } else if (nums[pivot] > target) {
                end = pivot - 1;
            } else {
                start = pivot + 1;
            }
        }

        return -1;
    }

    private int breakPoint(int start, int end) {
        // no rotation performed on the array, i.e. already sorted
        if (nums[start] < nums[end]) {
            return 0;
        }

        while (start <= end) {
            // if there is rotation, find its index
            int pivot = start + (end - start) / 2;
            if (nums[pivot] > nums[pivot + 1])
                return pivot + 1;
            else {
                if (nums[pivot] >= nums[start]) {
                    start = pivot + 1;
                } else {
                    end = pivot - 1;
                }
            }
        }

        return 0;
    }
}