import java.util.Arrays;

public class SRMCards {
//https://arena.topcoder.com/#/u/practiceCode/14494/15565/11341/2/307615
    public static int maxTurns(int [] cards) {
        int length =  cards.length;
        Arrays.sort(cards);
        int dp[] = new int[length];
        dp[0]=1;
        dp[1]= (cards[0]==(cards[1]-1))? 1 : 2;
        for(int idx=2;idx<length;idx++) {
            if (cards[idx] == cards[idx - 1] + 1) {
                dp[idx] = Math.max(dp[idx - 2] + 1, dp[idx - 1]);
            } else {
                dp[idx] = dp[idx - 1] + 1;
            }
        }
        return dp[length-1];
    }
}
