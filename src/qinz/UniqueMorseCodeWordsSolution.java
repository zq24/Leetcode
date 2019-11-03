package qinz;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWordsSolution {

    String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> res = new HashSet<>();
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder morseString = new StringBuilder();
            for(int j = 0; j < word.length(); j++) {
                morseString.append(morse[word.charAt(j) - 'a']);
            }
            res.add(morseString.toString());
        }
        return res.size();
    }
}
