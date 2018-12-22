public class TextCompressor {
//https://arena.topcoder.com/#/u/practiceCode/1449/3186/3442/2/1449
    public static String longestRepeat(String sourceText) {
        int maxLength = 0;
        String longestSubStr = "";
        for(int i=1;i<=(int)Math.ceil((double)sourceText.length()/2);i++) {
            for(int j=0;j+i<sourceText.length();j++) {
                String subStr = sourceText.substring(j,j+i);
                String str1 = sourceText.substring(0,j);
                String str2 = sourceText.substring(j+i, sourceText.length());
                if(str1.contains(subStr) || str2.contains(subStr)) {
                    if(subStr.length() > maxLength) {
                        longestSubStr = subStr;
                        maxLength = subStr.length();
                    }
                }
            }
        }
        return longestSubStr;
    }
}
