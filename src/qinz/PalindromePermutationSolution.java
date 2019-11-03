package qinz;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class PalindromePermutationSolution {
    public static boolean canPermutePalindrome(String s) {
        //times that each character appears
        TreeMap<Character, Integer> map = new TreeMap<>();
        for(int i = 0; i < s.length(); i++) {
           if(map.get(s.charAt(i)) == null) {
               map.put(s.charAt(i), 1);
           } else {
               int lastFrequency = map.get(s.charAt(i));
               lastFrequency++;
               map.put(s.charAt(i), lastFrequency);
           }
        }
        int times = 0;
        for(Map.Entry m:map.entrySet()) {
            if((int)m.getValue() % 2 != 0){
                times++;
            }
        }
        if(times > 1) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(canPermutePalindrome("code"));
    }
}
