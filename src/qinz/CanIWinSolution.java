package qinz;

public class CanIWinSolution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int total = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (total < desiredTotal) {
            return false;
        }
        return false;
    }
}
