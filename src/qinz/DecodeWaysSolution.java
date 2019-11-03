package qinz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DecodeWaysSolution {
    char[] map = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /*
    public static int numDecodings(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder ways = new StringBuilder();
        numDecodings(s, res, ways);
        return res.size();
    }

    private static void numDecodings(String s, List<String> res, StringBuilder cur) {
        if (s.equals("")) {
            res.add(cur.toString());
        }

        StringBuilder code = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            code.append(s.charAt(i));
            int temp = Integer.parseInt(code.toString());
            if (temp >= 1 && temp <= 26) {
                String remain = s.substring(i + 1);
                cur.append(map[temp - 1]);
                StringBuilder possible = new StringBuilder(cur);
                numDecodings(remain, res, possible);
                cur.delete(cur.length() - 1, cur.length());
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("123456789"));
    }*/

    static Map<String, Integer> decodeWays = new HashMap<>();

    public static int numDecodings(String s) {
        return numDecodingsHelper(s);
    }

    private static int numDecodingsHelper(String s) {
        if (s.equals("")) {
            return 1;
        }
        if (decodeWays.containsKey(s)) {
            return decodeWays.get(s);
        }
        int numOfWays;
        int oneLetter = 0;
        int twoLetter = 0;
        if (s.charAt(0) >= '1' &&  s.charAt(0) <= '9') {
            oneLetter = numDecodingsHelper(s.substring(1));
        }
        if (s.length() >= 2) {
            if ((s.charAt(0) == '1' && (s.charAt(1) >= '0' && s.charAt(1) <= '9')) ||
                    (s.charAt(0) == '2' && (s.charAt(1) >= '0' && s.charAt(1) <= '6'))) {
                twoLetter = numDecodingsHelper(s.substring(2));
            }
        }
        numOfWays = oneLetter + twoLetter;
        decodeWays.put(s, numOfWays);
        return numOfWays;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("123456789"));
    }
}
