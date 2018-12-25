import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;

public class LuckyCycle {
//https://arena.topcoder.com/#/u/practiceCode/16535/49028/13958/2/326830
    static public class Node{
        int v;
        int numS, numF;
        int length;
        public Node(int v, int numS, int numF, int length) {
            this.v= v;
            this.numS = numS;
            this.numF = numF;
            this.length=length;
        }
    }

//    public static void main(String args[]) {
//        int [] edge1 = new int[]{1, 2, 3, 5, 6};
//        int [] edge2 = new int[]{2, 3, 4, 3, 5};
//        int [] weight = new int[]{4, 7, 7, 7, 7};
//        int[] ans = getEdge(edge1, edge2, weight);
//        if(ans.length>0) {
//            System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
//        }
//
//    }

    static public int[] getEdge(int[] edge1, int[] edge2, int[] weight) {
        ArrayList<ArrayList<Pair<Integer, Integer>>> adjList = new ArrayList<>();
        int n=edge1.length+1;
        for(int i=0;i<n;i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edge1.length;i++){
            adjList.get(edge1[i]-1).add(new Pair(edge2[i]-1, weight[i]));
            adjList.get(edge2[i]-1).add(new Pair(edge1[i]-1, weight[i]));
        }

        for(int i=0;i<n;i++) {
            Pair<Pair<Integer, Integer>, Integer> ans = doBFS(i, adjList);
            if(ans!=null) {
                return new int[]{ans.getKey().getKey(), ans.getKey().getValue(), ans.getValue()};
            }
        }

        return new int[]{};
    }

    static Pair<Pair<Integer, Integer>, Integer> doBFS (int src,
                                                        ArrayList<ArrayList<Pair<Integer, Integer>>> adjList) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(src, 0, 0, 0));
        boolean [] visited = new boolean [adjList.size()];
        visited[src] = true;

        while(!q.isEmpty()) {
            Node front = q.poll();
            int v = front.v;
            int numS = front.numS;
            int numF = front.numF;
            int length = front.length;
            if( length >1 && (Math.abs(numF-numS)==1)) {
                return new Pair<>(new Pair<>(src+1, v+1), (numF>numS?7:4));
            }
            for (Pair<Integer, Integer> ele : adjList.get(v)) {
                int u = ele.getKey();
                int w = ele.getValue();
                if(!visited[u]) {
                    visited[u]=true;
                    int newS = numS+ (w==7? 1:0);
                    int newF = numF+ (w==4? 1:0);
                    q.add(new Node(u, newS, newF, length+1));
                }
            }
        }
        return null;
    }
}
