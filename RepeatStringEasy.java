import static java.lang.Math.max;

public class RepeatStringEasy {
    public static int maximalLength(String s) {
        int n = s.length();
        int maxLength=0;
        for(int i=1;i<=n;i++) {
            String a = s.substring(0,i);
            String b = s.substring(i, n);
            maxLength = max(findLCS(a, b), maxLength);
        }

        return maxLength;
    }


    static int findLCS(String a, String b) {
        int n=a.length();
        int m =b.length();
        int [][]dp = new int[n][m];
        int maxSeq = 0;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                int a1 = a.charAt(i)==b.charAt(j) ?
                        (1 + (i-1>=0&&j-1>=0 ? dp[i-1][j-1] : 0) ): 0;
                int b1 = i-1>=0 ? dp[i-1][j] : 0;
                int c1 = j-1>=0 ? dp[i][j-1] : 0;
                dp[i][j] = max(a1, max(b1,c1));
                maxSeq = max(dp[i][j], maxSeq);
            }
        }

        return maxSeq*2;
    }
}
