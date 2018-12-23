import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SentenceDecomposition {
//https://arena.topcoder.com/#/u/practiceCode/13575/7776/8692/2/298184
//    public static void main (String args[]) {
//        String sentence = "thisismeaningless";
//        String [] validWords = {"this", "is", "meaningful"};
//        System.out.println(decompose(sentence,validWords));
//    }

    static public int decompose(String sentence, String[] validWords) {
        HashMap<String, ArrayList<String>> wordMap = getWordMap(validWords);

        int [] dp =new int [sentence.length()];
        for(int i=0;i<dp.length;i++) {
            dp[i]=Integer.MAX_VALUE;
        }
        dp[0] = getMinCost(sentence.substring(0,1), wordMap);

        for(int i=1; i<sentence.length(); i++) {
            int minCost = Integer.MAX_VALUE;
            for(int j=0; j<=i; j++) {
                String wordHere = sentence.substring(j,i+1);
                if(j-1<0 || dp[j-1]!=Integer.MAX_VALUE) {
                    int prevCost = j-1<0 ? 0 : dp[j-1];
                    int thisCost = getMinCost(wordHere, wordMap);
                    if(thisCost!=Integer.MAX_VALUE) {
                        minCost = Math.min(prevCost+thisCost, minCost);
                    }
                }
            }

            dp[i]=minCost;
        }

        return  dp[dp.length-1] == Integer.MAX_VALUE ? -1 : dp[dp.length-1];
    }

    static int getMinCost(String word, HashMap<String, ArrayList<String>> wordMap) {
        char[] sortW = word.toCharArray();
        Arrays.sort(sortW);
        String sortStr = String.valueOf(sortW);
        if(!wordMap.containsKey(sortStr)) {
            return Integer.MAX_VALUE;
        }
        ArrayList<String> dictWords = wordMap.get(sortStr);
        int min = Integer.MAX_VALUE;
        for(String dictWord : dictWords) {
            min = Math.min(min, getConversionCost(word, dictWord));
        }
        return min;
    }

    static int getConversionCost(String word, String dictWord) {
        int diff=0;
        for(int i=0;i<word.length();i++) {
            diff+= word.charAt(i)!=dictWord.charAt(i) ? 1:0;
        }
        return diff;
    }

    static HashMap<String, ArrayList<String>> getWordMap(String[] validWords) {
        HashMap<String, ArrayList<String>> wordMap = new HashMap<>();
        for(String word : validWords) {
            char[] w = word.toCharArray();
            Arrays.sort(w);
            String sortW = String.valueOf(w);
            if(!wordMap.containsKey(sortW)) {
                ArrayList<String> list = new ArrayList<>();
                list.add(word);
                wordMap.put(sortW, list);
            }
            else  {
                ArrayList<String> list = wordMap.get(sortW);
                list.add(word);
                wordMap.put(sortW, list);
            }
        }
        return wordMap;
    }
}
