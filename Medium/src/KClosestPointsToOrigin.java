import java.util.Arrays;
import java.util.Comparator;

public class KClosestPointsToOrigin {
/*
    @author: Linh Tran
    @version: May 31, 2021

    Runtime and usage info of the first solution:
    Runtime: 75 ms, faster than 5.06% of Java online submissions for K Closest Points to Origin.
    Memory Usage: 113.8 MB, less than 5.62% of Java online submissions for K Closest Points to Origin.

    Check second solution for better runtime:
    Runtime: 8 ms, faster than 85.80% of Java online submissions for K Closest Points to Origin.
    Memory Usage: 115.3 MB, less than 5.25% of Java online submissions for K Closest Points to Origin.
 */

    // First solution
//    public int[][] kClosest(int[][] points, int k) {
//        double[][] dist = new double[points.length][2];
//        int[][] result = new int[k][2];
//
//        for (int i = 0; i< points.length; i++) {
//            dist[i][0] =  Math.sqrt(points[i][0]*points[i][0] +points[i][1]*points[i][1]);
//            dist[i][1] = (double) i;
//        }
//
//        if (dist.length > 0) {
//            Arrays.sort(dist, Comparator.comparingDouble(o -> o[0]));
//
//            int j=0;
//            while (k>0){
//                int index = (int) dist[j][1];
//                result[j][0] = points[index][0];
//                result[j++][1] = points[index][1];
//                k--;
//            }
//        } else {
//            return null;
//        }
//        return result;
//    }

    // Second solution: Idea credit goes to user3600W
    public int[][] kClosest(int[][] points, int k) {
        int low =0;
        int high = points.length-1;
        int pivot=0;

        while (low<high){
            pivot = partition(points, low, high);
            if (pivot == k || pivot == k-1){
                return Arrays.copyOfRange(points, 0, k);
            } else if (pivot > k){
                high = pivot -1;
            } else {
                low = pivot +1;
            }
        }
        return null;
    }

    private int partition (int[][] points, int low, int high){
        // pick a random pivot and set it to be the last val
        int random = low + ((int)Math.random())%(high-low);
        swap(points, random, high);
        double pivotDist = dist(points, high); // set pivot to be the last point

        int i = low-1; // i keeps track of the index of the last found smaller than                       // pivot element
        for (int j=low; j<high; j++){
            if (dist(points, j) <= pivotDist){
                i++;
                swap(points, i, j);
            }

        }
        swap(points, i+1, high); // swap pivot to the right place
        return i+1;
    }

    private double dist(int[][] points, int index){
        return Math.sqrt(points[index][0]*points[index][0]+points[index][1]*points[index][1]);
    }

    private void swap(int[][] points, int t1, int t2){
        int[] temp = points[t1];
        points[t1] = points[t2];
        points[t2] = temp;
    }
}
