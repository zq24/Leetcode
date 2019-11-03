package qinz;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbersSolution {
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> selfDividingNumbers = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            boolean selfDividing = true;
            String numInString = Integer.toString(i);
            char[] digits = numInString.toCharArray();
            for(char digit : digits) {
                int digitInNum = digit - '0';
                if(digitInNum == 0 || i % digitInNum != 0) {
                    selfDividing = false;
                    break;
                }
            }
            if(selfDividing)
                selfDividingNumbers.add(i);
        }
        return selfDividingNumbers;
    }

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1, 22));
    }
}
