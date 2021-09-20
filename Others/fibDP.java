import java.util.*;

public class fibDP {
    public static void main(String[] args) {
        // TC: O(fib(n))
        System.out.println(fibWithMemoization(100)); // 354224848179261915075
        System.out.println(fibWithMemoization(10));
        System.out.println(fibWithMemoization(11));
        System.out.println(fibWithMemoization(15));
        System.out.println(fibWithMemoization(20));
    }

    static Map<Integer, Long> memoiz = new HashMap<>();

    static long fibWithMemoization(int n) {
        // base casea
        if (n == 0 || n == 1) {
            return (long) n;
        }

        if (memoiz.containsKey(n)) {
            return memoiz.get(n);
        }

        long curFib = fibWithMemoization(n - 1) + fibWithMemoization(n - 2);

        // memorize
        memoiz.put(n, curFib);

        return memoiz.get(n);
    }
}
