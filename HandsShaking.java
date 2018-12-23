public class HandsShaking {
//    public static void main(String args[]) {
//        System.out.println(countPerfect(8));
//    }

    public static long countPerfect(int n) {
        if(n%2==1)
            return 0;

        long []dp = new long[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++) {
            if(i%2==1) {
                dp[i]=0;
                continue;
            }
            for(int j=1;j<i;j++) {
                dp[i]+=dp[j-1]*dp[i-j-1];
            }
        }
        return dp[n];
    }
}
