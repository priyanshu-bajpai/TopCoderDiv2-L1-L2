public class ShorterSuperSum {
//https://arena.topcoder.com/#/u/practiceCode/14290/9079/10240/2/304206
    public static int calculate(int k, int n) {
        int memo[][] = new int[k+1][n+1];

        for(int i=0;i<=n;i++) {
            memo[0][i]=i;
        }

        for(int idx =1; idx<=k;idx++) {
            for(int m=1;m<=n;m++) {
                for(int j=1;j<=m;j++) {
                    memo[idx][m]+=memo[idx-1][j];
                }
            }
        }
        return memo[k][n];
    }
}