public class MedianOfTwoSortedArrays {
    /*
    **Credit solution goes to: Tushar Roy
    @author: Linh Tran
    @version: Jun 18th, 2021

    Runtime and usage info of the solution:
    Runtime: 2 ms, faster than 99.85% of Java online submissions for Median of Two Sorted Arrays.
    Memory Usage: 39.8 MB, less than 96.59% of Java online submissions for Median of Two Sorted Arrays.
    */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // make sure length of nums1 < length of nums2
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        // partition both array into 2 halves such that the length of
        // the combined left partitions of both arrays when be the middle
        // value of the merged array
        int l1 = nums1.length;
        int l2 = nums2.length;
        int start = 0, end = l1;

        while(start <= end) {
            // partition is the number of elements on the left side of an array that
            // we take at each partitioning process
            int partition1 = (end+start)/2;
            int partition2 = (l1+l2+1)/2 - partition1;

            // because partition is the number of elements we take, the value at that
            // partition will be at index = partition - 1
            // partition = 0 means we do not take anything on the left
            // partition = length of the array means we do not take anything on the right
            int maxLeft1 = partition1 == 0? Integer.MIN_VALUE : nums1[partition1-1];
            int minRight1 = partition1 == l1? Integer.MAX_VALUE : nums1[partition1];

            int maxLeft2 = partition2 == 0? Integer.MIN_VALUE : nums2[partition2-1];
            int minRight2 = partition2 == l2? Integer.MAX_VALUE : nums2[partition2];

            // if we find the correct partition
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((l1+l2)%2 == 0) {// if there are even numbers of elements
                    return (double) (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2))/2;
                } else {
                    return (double) (Math.max(maxLeft1, maxLeft2));
                }
            } else if (maxLeft1 > minRight2) { // need to go left-ward on array 1
                end = partition1 - 1;
            } else if (maxLeft2 > minRight1) { // need to go right-ward on array 1
                start = partition1 + 1;
            }
        }


        return 0;
    }
}
