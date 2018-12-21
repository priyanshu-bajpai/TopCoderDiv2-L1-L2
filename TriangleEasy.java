public class TriangleEasy {
//https://arena.topcoder.com/#/u/practiceCode/16769/52579/14324/2/328970
    public static int find(int n, int[] x, int[] y) {
        int numEdges = x.length;
        if(x.length==0) {
            return 3;
        }

        int [][] g = new int[n][n];
        for(int i=0;i<numEdges;i++) {
            g[x[i]][y[i]] = 1;
            g[y[i]][x[i]] = 1;
        }

        boolean areThreeConnected = false;
        for(int i=0;i<numEdges;i++) {
            int u = x[i];
            int v = y[i];

            for(int j=0;j<n;j++) {
                if(j!=v && g[u][j]==1) {
                    areThreeConnected=true;
                    if(g[j][v]==1) {
                        return 0;
                    }
                }
            }
        }

        return areThreeConnected ? 1:2;
    }
}
