import java.util.HashMap;

public class StringHalving {
//https://arena.topcoder.com/#/u/practiceCode/17050/59423/14760/2/330832
    public static void main(String args[] ){
        String input = "rvofqorvfq";
        System.out.println(lexsmallest(input));
    }
    static String lexsmallest(String s) {
        String result="z";
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(!map.containsKey(ch)) {
                map.put(ch, i);
            }
            map.put(ch, Math.max(i, map.get(ch)));
        }

        for(int i=0;i<s.length();i++) {
            boolean canBeFirst=true;
            for(int j=i-1;j>=0;j--) {
                if(map.get(s.charAt(j))<i) {
                    canBeFirst=false;
                }
            }
            if(canBeFirst) {
                result = result.compareTo(String.valueOf(s.charAt(i))) < 0 ?
                        result : String.valueOf(s.charAt(i));
            }
        }
        return result;
    }
}
