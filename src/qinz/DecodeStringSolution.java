package qinz;

import java.util.Stack;

public class DecodeStringSolution {
    public static String decodeString(String s) {
        Stack<Integer> repetitions = new Stack<>();
        Stack<String> decode = new Stack<>();
        StringBuilder res = new StringBuilder();
        StringBuilder result;

        for (int i = 0; i < s.length();) {
            if (Character.isDigit(s.charAt(i))) {
                int digitLength = lengthOfDigits(s, i);
                String length = s.substring(i, i + digitLength);
                repetitions.push(Integer.parseInt(length));
                i += digitLength;
            } else if (s.charAt(i) == '[') {
                if (res.length() != 0) {
                    decode.push(res.toString());
                }
                res.delete(0, res.length());
                i += 1;
            } else if (s.charAt(i) == ']') {
                result = (decode.isEmpty()) ? new StringBuilder() : new StringBuilder(decode.pop());
                int numOfCode = repetitions.pop();
                if (res.toString().equals("")) {
                }
                for (int j = 0; j < numOfCode; j++) {
                    if (res.toString().equals("")) {

                    } else {
                        result.append(res.toString());
                    }
                }
                decode.push(result.toString());
                res.delete(0, res.length());
                i += 1;
            } else {
                res.append(s.charAt(i));
                i += 1;
            }
        }
        return decode.pop();
    }

    private static int lengthOfDigits(String s, int start) {
        int length = 0;
        for (int i = start; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                length += 1;
            } else {
                break;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }
}