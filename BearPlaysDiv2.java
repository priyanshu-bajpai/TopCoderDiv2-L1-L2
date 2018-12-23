import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BearPlaysDiv2 {
//    public static void main (String args[]) {
//        System.out.println(equalPiles(225,500,475));
//    }
    public static class Config {
        int A;
        int B;
        int C;
        public Config(int A, int B, int C) {
            int [] sort = new int[]{A, B, C};
            Arrays.sort(sort);
            this.A=sort[0];
            this.B=sort[1];
            this.C=sort[2];
        }

        @Override
        public boolean equals(Object obj) {
            return this.A==((Config)obj).A &&
                    this.B==((Config)obj).B &&
                    this.C==((Config)obj).C;
        }

        public int hashCode () {
            return 7*Objects.hashCode(A)^11*Objects.hashCode(B)^13*Objects.hashCode(C);
        }
    }

    public static String equalPiles(int A, int B, int C) {
        int total = A+B+C;
        if (total%3!=0)
            return "impossible";

        int euqals = (total)/3;
        HashSet<Config> dp = new HashSet<>();

        Queue<Config> q = new LinkedList<>();
        q.add(new Config(euqals,euqals,euqals));
        while (!q.isEmpty()) {
            Config con = q.poll();
            int a = con.A;
            int b = con.B;
            int c = con.C;
            dp.add(con);
            if(a%2==0) {
                int newB = b+a/2;
                if(!dp.contains(new Config(a/2, newB, c))) {
                    q.add(new Config(a/2, newB, c));
                }

                int newC = c+a/2;
                if(!dp.contains(new Config(a/2, b, newC))) {
                    q.add(new Config(a/2, b, newC));
                }
            }

            if(b%2==0) {
                int newA = a+b/2;
                if(!dp.contains(new Config(newA, b/2, c))) {
                    q.add(new Config(newA, b/2, c));
                }

                int newC = c+b/2;
                if(!dp.contains(new Config(a, b/2, newC))) {
                    q.add(new Config(a, b/2, newC));
                }
            }

            if(c%2==0) {
                int newA = a+c/2;
                if(!dp.contains(new Config(newA, b, c/2))) {
                    q.add(new Config(newA, b, c/2));
                }

                int newB = c/2+b;
                if(!dp.contains(new Config(a, newB, c/2))) {
                    q.add(new Config(a, newB, c/2));
                }
            }
        }

        return dp.contains(new Config(A, B, C)) ? "possible" : "impossible";
    }
}
