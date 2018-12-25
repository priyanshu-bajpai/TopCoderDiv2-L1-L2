public class CirclesCountry {
    public static int leastBorders(int[] X, int[] Y, int[] R, int x1, int y1, int x2, int y2) {

        int res=0;
        for(int i=0;i<X.length;i++) {
            boolean fInside = false;
            boolean sInside = false;

            if(dist(x1, X[i], y1, Y[i])< R[i]*R[i]) {
                fInside=true;
            }
            if(dist(x2, X[i], y2, Y[i])< R[i]*R[i]) {
                sInside=true;
            }
            if(fInside^sInside) {
                res++;
            }
        }

        return res;
    }

    static int dist(int x1, int x2, int y1, int y2) {
        return (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
    }
}
