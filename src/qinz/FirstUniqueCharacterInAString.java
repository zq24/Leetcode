package qinz;

public class FirstUniqueCharacterInAString {
    public static int firstUniqChar(String s) {
        boolean flag;
        for(int i = 0; i < s.length(); i++) {
            flag = true;
            for (int j = 0; j < s.length(); j++) {
                if (i == j) {
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }

}
