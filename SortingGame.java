import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class SortingGame {
    static public class Node {
        Long val;
        int dist;
        public Node(Long value, int dist) {
            val = value;
            this.dist=dist;
        }
    }

    public static void main(String args[]) {
        int board[] = new int[]{5,4,3,2,1};
        int k =2;
        System.out.println(fewestMoves(board, k));
    }
    public static int fewestMoves(int[] board, int k) {
        int length = board.length;
        long src = getConvertedBit(board);
        Arrays.sort(board);
        long dest = getConvertedBit(board);
        int distance = doBFS(src, dest, length, k);
        return distance;
    }

    static int doBFS(long src, long dest, int length, int k) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(src, 0));
        HashSet<Long> set = new HashSet<>();
        set.add(src);

        while(!q.isEmpty()) {
            Node front = q.poll();
            Long val = front.val;
            int dist = front.dist;

            if(val==dest) {
                return dist;
            }
            for(int i=0;i+k-1<length;i++) {
                long iKReversed = getKReversed(i, length, k, val);
                if(!set.contains(iKReversed)) {
                    set.add(iKReversed);
                    q.add(new Node(iKReversed, dist+1));
                }
            }
        }

        return -1;
    }

    static long getKReversed(int idx, int length, int k, long num) {
        int [] original = getConvertedBoard(num,length);
        int d = idx+k-1;
        for(int i=idx;i<d;) {
            swap(original, i, d);
            d--;
            i++;
        }

        return getConvertedBit(original);
    }

    static long getConvertedBit(int[] board) {
        long num=board[0];
        for(int i=1;i<board.length;i++) {
            num=num<<4;
            num|=board[i];
        }
        return num;
    }

    static int[] getConvertedBoard(long num, int length) {
        long sup = 15;
        int [] board = new int [length];
        for(int i=length-1;i>=0;i--) {
            board[i] = (int) (num&sup);
            num>>=4;
        }

        return board;
    }

    static void swap(int[] board, int i, int j) {
        int temp = board[i];
        board[i] = board[j];
        board[j] = temp;
    }
}
