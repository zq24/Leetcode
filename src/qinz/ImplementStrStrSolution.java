package qinz;

public class ImplementStrStrSolution {
    public int strStr(String haystack, String needle) {
        if(needle == "") {
            return 0;
        }

        int length = needle.length();
        for(int i = 0; i <= haystack.length() - length; i++) {
            if(haystack.substring(i, i + length).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
