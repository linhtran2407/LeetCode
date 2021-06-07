public class MaximumPointsYouCanObtainFromCards {

    /*
    @author: Linh Tran
    @version: June 6th, 2021
    Runtime and usage info:
    Runtime: 5 ms, faster than 8.61% of Java online submissions for Maximum Points You Can Obtain from Cards.
    Memory Usage: 61.9 MB, less than 5.71% of Java online submissions for Maximum Points You Can Obtain from Cards.
*/

    public int maxScore(int[] cardPoints, int k) {
        if (k==0 || cardPoints.length == 0){return 0;}
        int result;
        int sumLeft = 0;
        int sumRight = 0;

        // calculate the sum of first k elements
        for (int i=0; i<k && i<cardPoints.length; i++){
            sumLeft += cardPoints[i];
        }

        if (k >= cardPoints.length) {return sumLeft;}

        // temporarily set result to sum of left k elements
        result = sumLeft;

        for (int i= k-1, j = cardPoints.length-1; i >=0 && j >= cardPoints.length-k; i--, j--){
            // update the sum right
            sumRight += cardPoints[j];
            // get 1 more element from the end and 1 less element from the start
            int otherSum = sumLeft - cardPoints[i] + sumRight;
            if (otherSum > result){
                result = otherSum;
            }
            // update the sum left
            sumLeft -= cardPoints[i];
        }
        return result;
    }
}
