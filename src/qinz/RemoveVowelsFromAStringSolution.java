package qinz;

public class RemoveVowelsFromAStringSolution {
    public String removeVowels(String S) {
        StringBuilder res = new StringBuilder(S);
        for (int i = 0; i < res.length();) {
            if (res.charAt(i) == 'a' || res.charAt(i) == 'e' || res.charAt(i) == 'i' ||
                    res.charAt(i) == 'o' || res.charAt(i) == 'u') {
                res.deleteCharAt(i);
            } else {
                i += 1;
            }
        }
        return res.toString();
    }
}
