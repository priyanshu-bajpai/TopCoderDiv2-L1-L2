import java.util.PriorityQueue;

public class CostOfDancing {
//https://arena.topcoder.com/#/u/practiceCode/16003/41033/13195/2/322644
    public static int minimum(int K, int[] danceCost) {
        int n=danceCost.length;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int idx=0;
        while(idx<n-K+1) {
            heap.add(danceCost[idx]);
            idx++;
        }
        int totalCost = heap.poll();
        while (idx<n) {
            heap.add(danceCost[idx]);
            totalCost+=heap.poll();
            idx++;
        }
        return totalCost;
    }
}
