public class ThePalindrome {
//https://arena.topcoder.com/#/u/practiceCode/1550/4302/4651/2/1550
//    public static void main(String args[]) {
//        String s = "abdfhdyrbdbsdfghjkllkjhgfds";
//        System.out.println(find(s));
//    }

    public static int find(String s) {
        int length = s.length();
        int minAddition = length-1;
        for(int i=(int)Math.ceil((double)length/2.0)-1; i < length;i++) {
            int dist = 1;
            while ((i+dist)<length) {
                if(s.charAt(i-dist)!=s.charAt(i+dist)) {
                    break;
                }
                dist++;
            }
            if(i+dist==length) {
                minAddition = Math.min(minAddition, i - dist + 1);
            }
        }
        return minAddition + s.length();
    }
}
