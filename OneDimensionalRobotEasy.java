public class OneDimensionalRobotEasy {
//https://arena.topcoder.com/#/u/practiceCode/15878/37425/13000/2/320622
    public static int finalPosition(String commands, int A, int B) {
        int curPos=0;
        for(int i=0;i<commands.length();i++) {
           if(commands.charAt(i)=='R' && (curPos+1)<=B) {
               curPos++;
           }
           else if(commands.charAt(i)=='L' && (curPos-1)>=(-1*A)) {
               curPos--;
           }
        }
        return curPos;
    }
}
