import javafx.util.Pair;

public class RunLengthEncoding {
//https://arena.topcoder.com/#/u/practiceCode/1598/5524/5983/2/1598
    private static final String TOO_LONG = "TOO LONG";
    static String decode(String text) {
        int idx = 0;
        String result = "";

        while (idx < text.length()) {
            Pair<Integer, Integer> p = processRepetition(text, idx);

            int num = p.getValue();
            if (num == -1) { return TOO_LONG; }

            idx = p.getKey();
            for (int i = 0; i < num; i++) {
                result += text.charAt(idx);
            }

            if (result.length()>50)
                return TOO_LONG;
            idx++;
        }
        return result;
    }

    static Pair<Integer, Integer> processRepetition(String text, int idx) {
        int repetition=0;
        while(text.charAt(idx)>='0' && text.charAt(idx)<='9') {
            repetition*=10;
            repetition+=text.charAt(idx) - '0';
            idx++;
            if (repetition>50)
                return new Pair<>(idx, -1);
        }
        return new Pair<>(idx, repetition== 0 ? 1 : repetition);
    }
}
