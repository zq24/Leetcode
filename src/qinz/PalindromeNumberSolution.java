package qinz;

public class PalindromeNumberSolution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        String intToString = Integer.toString(x);
        for(int i = 0; i < intToString.length(); i++) {
            if(intToString.charAt(i) != intToString.charAt(intToString.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
