import java.util.LinkedList;
import java.util.Queue;

public class FriendScore {
//https://arena.topcoder.com/#/u/practiceCode/13785/9172/10343/2/300637
    public static class Friend {
        int idx;
        int level;
        public Friend(int idx, int level) {
            this.idx=idx;
            this.level=level;
        }
    }

    public static int highestScore(String[] friends) {
        int n = friends.length;
        int max2Friend =0;
        int maxLevel=1;

        for(int i=0;i<n;i++) {
            int twoFriends = 0;
            boolean [] visited = new boolean[n];
            Queue<Friend> q = new LinkedList<>();
            q.add(new Friend(i,0));

            int curLevel=0;
            while (!q.isEmpty()&& q.peek().level<=maxLevel) {
                Friend front = q.poll();
                int idx = front.idx;
                int level = front.level;
                visited[idx] = true;
                for(int j=0;j<friends[idx].length();j++) {
                    if(friends[idx].charAt(j)=='Y' && !visited[j]) {
                        twoFriends++;
                        visited[j]=true;
                        if(level+1<=maxLevel)
                            q.add(new Friend(j, level+1));
                    }
                }
            }
            max2Friend = Math.max(max2Friend, twoFriends);
        }

        return max2Friend;
    }
}
