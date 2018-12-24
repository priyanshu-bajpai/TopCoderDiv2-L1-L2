import static java.lang.Math.max;

import java.util.HashSet;
import java.util.Stack;

public class CubeStackingGame {
//https://arena.topcoder.com/#/u/practiceCode/17105/61677/14845/2/331127
//    public static void main(String args[]) {
//        int n= 4;
//        int [] c1= new int[] {1,1,1,1};
//        int [] c2= new int[] {2,2,2,4};
//        int [] c3= new int[] {3,3,3,3};
//        int [] c4= new int[] {4,4,4,2};
//        System.out.println(MaximumValue(n, c1, c2, c3, c4));
//    }

    public static class Node {
        int f1, f2, f3, f4;
        int level;
        public Node (int level, int f1, int f2, int f3, int f4) {
            this.level = level;
            this.f1 = f1;
            this.f2 = f2;
            this.f3 = f3;
            this.f4 = f4;
        }
    }

    static public int MaximumValue(int n, int[] c1, int[] c2, int[] c3, int[] c4) {
        int idx=0;

        int maxLevel = 1;
        int l1 = dfs(c1, c2, c3, c4);
        maxLevel = max(maxLevel, l1);
        int l2 = dfs(c1, c2, c3, c4);
        maxLevel = max(maxLevel, l2);
        int l3 = dfs(c1, c2, c3, c4);
        maxLevel = max(maxLevel, l3);
        int l4 = dfs(c1, c2, c3, c4);
        maxLevel = max(maxLevel, l4);
        return maxLevel;
    }

    static int  dfs(int[]  c1, int [] c2, int [] c3, int [] c4) {
        int f1c = 1 << c1[0];
        int f2c = 1 << c2[0];
        int f3c = 1 << c3[0];
        int f4c = 1 << c4[0];

        Node n1 = new Node(1, f1c, f2c, f3c, f4c);
        Node n2 = new Node(1, f4c, f1c, f2c, f3c);
        Node n3 = new Node(1, f3c, f4c, f1c, f2c);
        Node n4 = new Node(1, f2c, f3c, f4c, f1c);

        HashSet<Node> set = new HashSet<>();
        set.add(n1);
        set.add(n2);
        set.add(n3);
        set.add(n4);

        Stack<Node> st = new Stack<>();
        st.push(n1);
        st.push(n2);
        st.push(n3);
        st.push(n4);

        int maxLevel = 1;
        while(!st.isEmpty()) {
            Node node = st.pop();
            int level = node.level;
            maxLevel = max(level, maxLevel);
            if(level<c1.length) {
                int f1 = node.f1;
                int f2 = node.f2;
                int f3 = node.f3;
                int f4 = node.f4;

                int newC1 = c1[level];
                int newC2 = c2[level];
                int newC3 = c3[level];
                int newC4 = c4[level];

                if((1<<newC1 & f1)==0 && (1<<newC2 & f2)==0 &&
                        (1<<newC3 & f3)==0 && (1<<newC4 & f4)==0) {
                    int newF1 = 1<<newC1 | f1;
                    int newF2 = 1<<newC2 | f2;
                    int newF3 = 1<<newC3 | f3;
                    int newF4 = 1<<newC4 | f4;
                    Node node1 = new Node(level+1, newF1, newF2, newF3, newF4);
                    if(!set.contains(node1)) {
                        set.add(node1);
                        st.add(node1);
                    }
                }

                if((1<<newC2 & f1)==0 && (1<<newC3 & f2)==0 &&
                        (1<<newC4 & f3)==0 && (1<<newC1 & f4)==0) {
                    int newF1 = 1<<newC2 | f1;
                    int newF2 = 1<<newC3 | f2;
                    int newF3 = 1<<newC4 | f3;
                    int newF4 = 1<<newC1 | f4;
                    Node node1 = new Node(level+1, newF1, newF2, newF3, newF4);
                    if(!set.contains(node1)) {
                        set.add(node1);
                        st.add(node1);
                    }
                }

                if((1<<newC3 & f1)==0 && (1<<newC4 & f2)==0 &&
                        (1<<newC1 & f3)==0 && (1<<newC2 & f4)==0) {
                    int newF1 = 1<<newC3 | f1;
                    int newF2 = 1<<newC4 | f2;
                    int newF3 = 1<<newC2 | f3;
                    int newF4 = 1<<newC1 | f4;
                    Node node1 = new Node(level+1, newF1, newF2, newF3, newF4);
                    if(!set.contains(node1)) {
                        set.add(node1);
                        st.add(node1);
                    }
                }

                if((1<<newC4 & f1)==0 && (1<<newC1 & f2)==0 &&
                        (1<<newC2 & f3)==0 && (1<<newC3 & f4)==0) {
                    int newF1 = 1<<newC4 | f1;
                    int newF2 = 1<<newC3 | f2;
                    int newF3 = 1<<newC2 | f3;
                    int newF4 = 1<<newC1 | f4;
                    Node node1 = new Node(level+1, newF1, newF2, newF3, newF4);
                    if(!set.contains(node1)) {
                        set.add(node1);
                        st.add(node1);
                    }
                }
            }
        }
        return maxLevel;
    }
}