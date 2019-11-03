package qinz;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddressesSolution {
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        restoreIpAddresses(res, "", 4, s);
        return res;
    }

    private static void restoreIpAddresses(List<String> res, String current, int part, String remain) {
        if (remain.equals("") && part == 0) {
            res.add(current);
            return;
        }

        if (remain.equals("") || part == 0) {
            return;
        }

        //select one, two, or three numbers
        for (int i = 1; i < 4; i++) {
            if (i > remain.length()) {
                return;
            }
            String newPossible = remain.substring(0, i);
            int newPossibleInNum = Integer.parseInt(newPossible);
            if (newPossibleInNum > 255 || (newPossible.length() > 1 && newPossible.charAt(0) == '0')) {
                continue;
            }
            String newConstructedIP = (current.equals("")) ? current + newPossible :
                    current + "." + newPossible;
            String remainStr = remain.substring(i);
            int remainPart = part - 1;
            restoreIpAddresses(res, newConstructedIP, remainPart, remainStr);
        }
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
    }
}
