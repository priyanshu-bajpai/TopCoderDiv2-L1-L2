public class NoRepeatPlaylist {

    static int MOD=1000000007;
    public static void main(String args[]) {
        System.out.println(numPlaylists(50,5,100));
    }

    public static int numPlaylists(int N, int M, int P) {
        int Y=N;
        int X=0;
        int s=0;
        long dp[][][] = new long[P+1][N+1][N+1];

        for(int i=0;i<=P;i++) {
            for (int j=0;j<=N;j++) {
                for (int k=0;k<=N;k++) {
                    dp[i][j][k]=-1;
                }
            }
        }

        return (int)getNumPlaylists(s, X, Y, P, M, dp);
    }

    public static long getNumPlaylists(int s, int X, int Y, int P, int M, long dp[][][]) {
        if(dp[s][X][Y] != -1)
            return dp[s][X][Y];
        int result = 0;

        if (s == P)
            result = Y == 0 ? 1 : 0;
        else {
            if (Y > 0) {
                result += (getNumPlaylists(s + 1, X + 1, Y - 1, P, M, dp) * Y)%MOD;
                result %=MOD;
            }
            if (X > M) {
                result += (getNumPlaylists(s + 1, X, Y, P, M, dp) * (X - M))%MOD;
                result %=MOD;
            }
        }

        dp[s][X][Y] = result%MOD;
        return dp[s][X][Y];
    }
}
