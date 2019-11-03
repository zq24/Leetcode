package qinz;

public class PlusOneSolution {
    public int[] plusOne(int[] digits) {
        boolean carry = false;
        int length = digits.length;
        int results = digits[length - 1] + 1;
        if(results > 9) {
            carry = true;
            digits[length - 1] = 0;
            length -= 2;
        } else {
            digits[length - 1] = results;
        }
        while(carry) {
            if(length < 0) {
                int[] newArr = new int[digits.length + 1];
                newArr[0] = 1;
                for(int i = 0; i < digits.length; i++) {
                    newArr[i + 1] = digits[i];
                }
                return newArr;
            }
            results = digits[length] + 1;
            if(results > 9) {
                digits[length] = 0;
            } else {
                digits[length] = results;
                carry = false;
            }
            length--;
        }
        return digits;
    }
}
