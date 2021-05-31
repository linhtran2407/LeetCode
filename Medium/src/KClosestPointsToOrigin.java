import java.util.Arrays;
import java.util.Comparator;

public class KClosestPointsToOrigin {
/*
    @author: Linh Tran
    @version: May 31, 2021

    Runtime and usage info of the first solution:
    Runtime: 75 ms, faster than 5.06% of Java online submissions for K Closest Points to Origin.
    Memory Usage: 113.8 MB, less than 5.62% of Java online submissions for K Closest Points to Origin.

 */

    // First solution
    public int[][] kClosest(int[][] points, int k) {
        double[][] dist = new double[points.length][2];
        int[][] result = new int[k][2];

        for (int i = 0; i< points.length; i++) {
            dist[i][0] =  Math.sqrt(points[i][0]*points[i][0] +points[i][1]*points[i][1]);
            dist[i][1] = (double) i;
        }

        if (dist.length > 0) {
            Arrays.sort(dist, Comparator.comparingDouble(o -> o[0]));

            int j=0;
            while (k>0){
                int index = (int) dist[j][1];
                result[j][0] = points[index][0];
                result[j++][1] = points[index][1];
                k--;
            }
        } else {
            return null;
        }
        return result;

    }
}
