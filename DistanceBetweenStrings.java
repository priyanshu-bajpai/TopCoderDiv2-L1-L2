import java.util.HashMap;

public class DistanceBetweenStrings {
//https://arena.topcoder.com/#/u/practiceCode/10818/6827/7606/2/10818
    public static void main(String args[]) {
        String a = "aaAaB";
        String b="BbaAa";
        String letterSet="ab";
        System.out.println(getDistance(a, b, letterSet));
    } 

    static int getDistance(String a, String b, String letterSet) {
        HashMap<Character, Integer> map1 = getMap(a);
        HashMap<Character, Integer> map2 = getMap(b);

        int distance=0;
        for(int idx=0;idx<letterSet.length();idx++) {
            char ch = letterSet.substring(idx, idx+1)
                    .toLowerCase()
                    .charAt(0);
            distance+=calculateDist(ch, map1, map2);
        }
        return distance;
    }

    static int calculateDist(char ch, HashMap<Character, Integer> map1,
                             HashMap<Character, Integer> map2) {
        int n1 = 0;
        int n2 = 0;

        if(map1.containsKey(ch)) {
            n1 = map1.get(ch);
        }
        if(map2.containsKey(ch)) {
            n2 = map2.get(ch);
        }
        return (n1-n2)*(n1-n2);
    }

    static HashMap<Character, Integer> getMap(String a) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int idx=0;idx<a.length();idx++) {
            char ch = a.substring(idx, idx+1)
                    .toLowerCase()
                    .charAt(0);
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch)+1);
            }
            else {
                map.put(ch,1);
            }
        }

        return map;
    }
}
