import java.util.LinkedList;
import java.util.Queue;

public class StepsConstruct {

    static int[][] d = new int[][] {{1,0,-1,0}, {0,-1,0,1}};

    public static class Node {
        int row;
        int col;
        int px;
        int py;
        int dist;
        public Node (int row, int col , int px, int py, int dist) {
            this.row = row;
            this.col = col;
            this.px = px;
            this.py = py;
            this.dist = dist;
        }
    }

//    public static void main(String [] args) {
//        String [] board = new String []{"...",
//                ".#.",
//                "..."};
//        int k = 12;
//        System.out.println(construct(board, k));
//    }

    public static String construct(String[] board, int k) {
        Node[][] nodMat = new Node[board.length][board[0].length()];

        for(int i=0;i<board.length;i++) {
            for(int j=0; j<board[0].length();j++) {
                nodMat[i][j] = new Node(i, j, i, j, Integer.MAX_VALUE);
            }
        }

        nodMat[0][0].dist=0;

        doBfs(nodMat[0][0], board, k, nodMat);
        String path = findPath(nodMat, k, board.length, board[0].length());
        return path;
    }

    static String findPath(Node[][] nodMat, int k, int n, int m) {
        if(nodMat[n-1][m-1].dist>k) {
            return "";
        }

        String path ="";

        int row=n-1;
        int col=m-1;
        if(Math.abs(nodMat[row][col].dist-k)%2!=0)
            return "";

        while(!(row==0 && col==0)) {
            int px = nodMat[row][col].px;
            int py = nodMat[row][col].py;

            if(row==px && col==py+1) {
                path = "R" + path;
            }
            else if(row==px-1 && col==py) {
                path = "U" + path;
            }
            else if(row==px && col==py-1) {
                path = "L" + path;
            }
            else if(row==px+1 && col==py) {
                path = "D" + path;
            }
            row=px;
            col=py;
        }

        String rep="";
        if(path.charAt(0)=='U') {
           rep = "UD";
        }
        else if (path.charAt(0)=='R') {
            rep = "RL";
        }
        else if(path.charAt(0)=='L') {
            rep = "LR";
        }
        else {
            rep = "DU";
        }

        int left = k-nodMat[n-1][m-1].dist;
        while(left>0) {
            path = rep + path;
            left-=2;
        }

        return path;
    }

    static void doBfs(Node src, String [] board, int maxDist,  Node[][] nodMat) {
        Queue<Node> q = new LinkedList<>();
        if(board[src.row].charAt(src.col)=='.' && src.dist<=maxDist)
            q.add(src);

        while(!q.isEmpty()) {
            Node front = q.poll();
            int row = front.row;
            int col = front.col;
            int dist = front.dist;

            if(row==board.length-1 && col==board[0].length()-1) {
                return;
            }

            if(dist+1 <= maxDist) {
                for(int i=0;i<4;i++) {
                    int newRow = row + d[0][i];
                    int newCol = col + d[1][i];
                    if(checkValid(newRow, newCol, board.length, board[0].length()) &&
                            board[newRow].charAt(newCol)!='#') {
                        Node nd = nodMat[newRow][newCol];
                        if(nd.dist > dist+1) {
                            q.add(nodMat[newRow][newCol]);
                            nodMat[newRow][newCol].px = row;
                            nodMat[newRow][newCol].py = col;
                            nodMat[newRow][newCol].dist = dist+1;
                        }
                    }
                }
            }
        }
    }

    static boolean checkValid(int x, int y, int n, int m) {
        return x>=0&& x<n && y>=0 && y<m;
    }
}
