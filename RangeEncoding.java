public class RangeEncoding {
    public static int minRanges(int[] arr) {
        int idx=0;
        int sets=0;
        //{2,4,5,6,8,9,10,11,12,15} l=10
        while(idx < arr.length) {
            sets+=1;
            while(idx+1 < arr.length && (arr[idx+1]==arr[idx]+1)) {
                idx++;
            }
            idx++;
        }

        return sets;
    }
}
