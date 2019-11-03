package qinz;

import java.util.HashMap;

public class HappyNumberSolution {
    public boolean isHappy(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(n, 1);
        String numInString = Integer.toString(n);
        int checkSum = digitSumSquare(numInString);
        while(checkSum != 1) {
            if(map.containsKey(checkSum)) {
                return false;
            } else {
                map.put(checkSum, 1);
            }
            numInString = Integer.toString(checkSum);
            checkSum = digitSumSquare(numInString);
        }
        return true;
    }

    private int digitSumSquare(String n) {
        int sum = 0;
        for(int i = 0; i < n.length(); i++) {
            sum += Math.pow(Integer.parseInt(n.substring(i, i + 1)), 2);
        }
        return sum;
    }
}
