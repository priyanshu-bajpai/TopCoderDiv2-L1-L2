public class SpreadsheetColumn {

    public static void main(String args[]) {
        int column=111;
        System.out.println(getLabel(column));
    }

    public static String getLabel(int column) {
        String converted="";
        while(column>0) {
            int greatestLastMultiple = (int) Math.ceil((double)column/26)-1;
            int idx = column - greatestLastMultiple*26;
            char thisLetter = (char)(64 + idx);
            converted = String.valueOf(thisLetter) + converted;
            column = greatestLastMultiple;
        }
        return converted;
    }
}
