public class FibonacciDiv2 {
//https://arena.topcoder.com/#/u/practiceCode/15985/40226/13159/2/322413
    public static int find(int n) {
        int prev = 0;
        int curFibo = 1;

        while (curFibo<n) {
            int temp = curFibo;
            curFibo = curFibo + prev;
            prev=temp;
        }

        return Math.min(curFibo-n, n-prev);
    }
}
