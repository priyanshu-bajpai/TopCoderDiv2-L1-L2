import static java.lang.Math.min;

import java.util.LinkedList;
import java.util.Queue;

public class PathGameDiv2 {
//https://arena.topcoder.com/#/u/practiceCode/16179/44398/13506/2/324173
    static int[][] d = new int[][] {{1,0,-1,0}, {0,-1,0,1}};
    public static  class Node {
        int x;
        int y;
        int dist;
        public Node(int x, int y, int dist) {
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }

//    public static void main(String args[]) {
//        String[] board = new String[] {"....#.##.....#..........."
//                ,"..#......#.......#..#...."};
//        System.out.println(calc(board));
//    }

    public static int calc(String[] board) {
        int legnth = board[0].length();
        int dist = legnth*2;
        int totalWhite = 0;

        for(int i=0;i<legnth;i++) {
            if(board[0].charAt(i)=='.')
                totalWhite++;
            if(board[1].charAt(i)=='.')
                totalWhite++;
        }
        if(board[0].charAt(0)=='.') {
            Node src = new Node(0, 0, 0);
            dist = min(dist, doBSF(src, board));
        }

        //System.out.println("dist1:" + dist);

        if(board[1].charAt(0)=='.') {
            Node src = new Node(1,0,0);
            dist = min(dist, doBSF(src, board));
        }
        //System.out.println("dist2:" + dist);

        return totalWhite-dist-1;
    }

    static int doBSF(Node src, String [] board) {
        Queue<Node> q = new LinkedList<>();
        q.add(src);
        boolean [][] visited=new boolean[2][board[0].length()];
        visited[src.x][src.y]=true;
        int minDist = board[0].length()*2;
        while(!q.isEmpty()) {
            Node f = q.poll();
            int x = f.x;
            int y = f.y;
            int dist = f.dist;
            if(y == (board[0].length()-1)) {
                minDist = min(minDist, dist);
                //System.out.println("X:" +  x + " Y: " + y + "Dist: " + dist + "minDist: " + minDist);
            }

            for(int i=0;i<4;i++) {
                int newX = x+d[0][i];
                int newY = y+d[1][i];
                if(checkValid(newX, newY, 2, board[0].length()) &&
                        board[newX].charAt(newY) == '.' && !visited[newX][newY]) {
                    //System.out.println("newX:" +  newX + " newY: " + newY + "Dist: " + (dist+1));
                    q.add(new Node(newX, newY, dist+1));
                    visited[newX][newY]=true;
                }
            }
        }

        return minDist;
    }

    static boolean checkValid(int x, int y, int n, int m) {
        return x>=0 && x<n && y>=0 && y<m;
    }
}
