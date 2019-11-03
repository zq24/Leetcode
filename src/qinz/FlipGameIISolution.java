package qinz;

public class FlipGameIISolution {
    public boolean canWin(String s) {
        return canWinHelper(s);
    }

    private boolean canWinHelper(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String flipString = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!canWinHelper(flipString)) {
                    return true;
                }
            }
        }
        return false;
    }
}
