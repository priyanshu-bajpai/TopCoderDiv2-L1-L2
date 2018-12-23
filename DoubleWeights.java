import java.util.TreeSet;

public class DoubleWeights {
    public static void main(String args[]) {
        String [] weight1 = new String[] {"..14",
                "..94",
                "19..",
                "44.."};
        String [] weight2 = new String[] {"..94",
                "..14",
                "91..",
                "44.."};
        System.out.println(minimalCost(weight1, weight2));
    }

    static class Node implements Comparable<Node>{
        int u;

        long w1;
        long w2;
        public Node(int u, long w1, long w2) {
            this.u=u;
            this.w1=w1;
            this.w2=w2;
        }

        @Override
        public int compareTo(Node n) {
            if((w1*w2) == (n.w1*n.w2)) {
                return u-n.u;
            }
            if((w1*w2 - n.w1*n.w2) >= (long)Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int)(w1*w2 - n.w1*n.w2);
        }

        @Override
        public boolean equals(Object n) {
            return this.u==((Node) n).u && this.w1==((Node) n).w1
                    && this.w2==((Node) n).w2;
        }
        @Override
        public String toString() {
            return w1 + " " + w2 + ">> "+ w1*w2;
        }
    }

    public static int minimalCost(String[] weight1, String[] weight2) {
        int src =0;
        int dest =1;
        int n =weight1.length;
        Node[] nodes = new Node[n];

        TreeSet<Node> heap = new TreeSet<>();
        nodes[src] = new Node (src, 0, 0);
        heap.add(nodes[src]);
        for (int i=0; i<n; i++) {
            if(i==src)
                continue;
            nodes[i] = new Node(i, Integer.MAX_VALUE, Integer.MAX_VALUE);
            heap.add(nodes[i]);
        }

        while (!heap.isEmpty()){
            Node front = heap.pollFirst();
           int u = front.u;
           long w1 = front.w1;
           long w2 = front.w2;

           if(u==dest) {
               return (int)(w1*w2);
           }

           for(int i=0;i<n;i++) {
               if(weight1[u].charAt(i)!='.' && heap.contains(nodes[i])) {
                   Node node = nodes[i];
                   long newW1 = w1 + (weight1[u].charAt(i)-'0');
                   long newW2 = w2 + (weight2[u].charAt(i)-'0');

                   if(node.w1 * node.w2 > newW1 * newW2){
                       heap.remove(node);
                       node.w2 = newW2;
                       node.w1 = newW1;
                       heap.add(node);
                   }
               }
           }
        }

        return nodes[dest].w2==Integer.MAX_VALUE ? -1 :
                (int)(nodes[dest].w2*nodes[dest].w1);
    }
}