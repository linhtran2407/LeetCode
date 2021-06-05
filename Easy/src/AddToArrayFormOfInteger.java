import java.util.ArrayList;
import java.util.List;

public class AddToArrayFormOfInteger {

    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int carry = 0;
        int i = num.length-1;
        int val = 0;
        while (k > 0 && i>=0){
            int temp = k%10; // get the last digit of k
            val = carry + num[i] + temp;
            num[i] = val % 10; // get the last digit of the sum "val"
            carry = (val) / 10; // carry the first digit of the sum "val"
            i--;
            k /= 10; // drop the last digit of k
        }

        // if the while loop stops because k=0
        if (i>=0){
            while(i>=0){
                val = carry + num[i]; // continue adding the remaining carry to num
                num[i] = val%10;
                carry = val/10;
                i--;
            }
        }

        // if the while loop stops because we have considered every element in num
        if(k>0){
            while (k>0){
                val = carry+ k%10; // continue adding the remaining last digit of k to num
                res.add(0, val%10); // then add to the fist position of result list
                carry =val/10;
                k /= 10;
            }
        }

        // add remaining carry to the first position after considering
        // all digits of k and elements in num
        if (carry != 0){
            res.add(0, carry);
        }

        // add the rest of num to the result list
        for(int j = 0; j<num.length;j++){
            res.add(num[j]);
        }

        return res;
    }
}
