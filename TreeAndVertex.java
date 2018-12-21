public class TreeAndVertex {
//https://arena.topcoder.com/#/u/practiceCode/16707/51501/14212/2/328399
    public static int get(int[] tree) {
        int vertices = tree.length+1;
        int [] v = new int[vertices];
        for(int i=0;i<vertices-1;i++) {
            v[tree[i]]++;
            v[i+1]++;
        }
        int maxIncomingEdges = 0;
        for(int i=0;i<vertices;i++) {
            maxIncomingEdges = Math.max(maxIncomingEdges, v[i]);
        }
        return maxIncomingEdges;
    }
}