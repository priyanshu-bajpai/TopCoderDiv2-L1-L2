import static java.lang.Math.max;
public class IncreasingSequencesEasy {
//    public static void main(String args[]) {
//        int []l = new int[] {1, 3, 1, 4};
//        int []r = new int[] {6, 5, 4, 6};
//        System.out.println(count(l, r));
//    }

    public static int count(int[] L, int[] R) {
        int maxLength = 0;

        for(int i=0;i<R.length;i++){
            maxLength = max(maxLength, R[i]-L[i]+1);
        }

        long [][] dp = new long[maxLength][R.length];

        int val =R[0]-L[0]+1;
        for(int i=0;i<val;i++) {
            dp[i][0]=1;
        }

        for(int col=1;col<R.length;col++){
            int minNow = L[col];
            int maxNow = R[col];
            int minLast = L[col-1];
            int maxLast = R[col-1];
            for(int row=0;row<maxNow-minNow+1;row++) {
                int i=row+minNow;
                int lastRow =0;
                while((i> minLast+lastRow) && lastRow<maxLast-minLast+1) {
                    dp[row][col] += dp[lastRow][col-1]%998244353;
                    dp[row][col]%=998244353;
                    lastRow++;
                }
            }
        }

        long result=0;
        for(int i=0;i<R[R.length-1] - L[L.length-1]+1;i++) {
            result+=dp[i][R.length-1]%998244353;
            result %=998244353;
        }

        return (int)result;
    }
}
