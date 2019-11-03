package qinz;

public class PowerOfTwoSolution {
    public boolean isPowerOfTwo(int n) {
        /*double result = Math.pow(2, 0);
        while(result < n) {
            result = result * 2;
        }
        if(n == result) {
            return true;
        } else {
            return false;
        }*/
        return Integer.bitCount(n) == 1;
    }
}
