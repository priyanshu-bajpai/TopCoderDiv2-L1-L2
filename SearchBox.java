public class SearchBox {
//https://arena.topcoder.com/#/u/practiceCode/10878/7179/8019/2/265755
    public static int find(String text, String search, String wholeWord, int start) {
        int end = text.length();
        text = text.substring(start, end);
        int newStart =0;
        boolean whole = wholeWord.equals("Y") ? true : false;

        if(text.contains(search)) {
            int idx = text.indexOf(search);
            System.out.println();
            if (whole) {
                if((idx==newStart || text.charAt(idx-1) == ' ') &&
                        (idx + search.length()==end ||
                                text.charAt(idx + search.length())==' ')) {
                    return start+idx;
                }
                else
                    return -1;
            }
            else {
                return  start+idx;
            }
        }
        return -1;
    }
}
