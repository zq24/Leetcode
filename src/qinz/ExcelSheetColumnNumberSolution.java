package qinz;

public class ExcelSheetColumnNumberSolution {
    public static int titleToNumber(String s) {
        int result = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            result += (s.charAt(i) - 'A' + 1) * Math.pow(26, s.length() - 1- i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }
}
