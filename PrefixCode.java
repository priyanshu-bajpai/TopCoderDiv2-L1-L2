public class PrefixCode {
    public static void main(String args[]) {
        String[] words = new String [] {"10001", "011", "100", "001", "10"};
        System.out.println(isOne(words));
    }

    public static class Trie{
        int wordsEndingHere;
        int idx;
        int wordsCrossedHere;
        Trie[] children;
        public Trie() {
            wordsCrossedHere =0;
            wordsEndingHere=0;
            children = new Trie[62];
        }
    }

    static String isOne(String[] words) {
        Trie root = new Trie();
        for(int i=0; i<words.length; i++) {
            String word = words[i];
            Trie t = root;
            for(int idx=0; idx<word.length(); idx++) {
                char charHere = word.charAt(idx);
                int asciIndex = getAsciIndex(charHere);
                if(t.children[asciIndex]==null) {
                    t.children[asciIndex] = new Trie();
                }
                t = t.children[asciIndex];
                t.wordsCrossedHere+=1;
                if(t.wordsEndingHere > 0) {
                    return "No, " + String.valueOf(t.idx);
                }
            }
            if(t.wordsCrossedHere>1) {
                return "No, " + String.valueOf(i);
            }
            t.idx=i;
            t.wordsEndingHere+=1;
        }

        return  "Yes";
    }

    static int getAsciIndex(char ch) {
        if(ch>='0' && ch<='9')
            return ch-'0';
        else if(ch>='A' && ch<='Z') {
            return ch-65+10;
        }
        else if (ch>='a'&&ch<='z') {
            return ch-97+10+26;
        }

        //invalid character provided
        return -1;
    }
}
