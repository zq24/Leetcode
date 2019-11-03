package qinz;

import java.util.Arrays;

public class FindWordsThatCanBeFormedbyCharactersSolution {
    public static int countCharacters(String[] words, String chars) {
        int sumOfLength = 0;
        char[] charArr = chars.toCharArray();
        Arrays.sort(charArr);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char[] wordChar = word.toCharArray();
            Arrays.sort(wordChar);
            if (wordChar.length <= charArr.length) {
                for (int j = 0, k = 0; j < wordChar.length && k < charArr.length;) {
                    if (wordChar[j] == charArr[k]) {
                        j += 1; k += 1;
                    } else {
                        k += 1;
                    }
                    if (j == wordChar.length) {
                        sumOfLength += wordChar.length;
                    }
                }
            }
        }
        return sumOfLength;
    }

    public static void main(String[] args) {
        String[] words = new String[] {"cat","bt","hat","tree"};
        String chars = "atach";
        System.out.println(countCharacters(words, chars));
    }
}
