package qinz;

import java.util.ArrayList;
import java.util.List;

public class OccurrencesAfterBigramSolution {
    public static String[] findOcurrences(String text, String first, String second) {
        String[] sep = text.split("\\s+");
        List<String> res = new ArrayList<>();
        for (int i = 0; i < sep.length; i = i + 1) {
            if ((i + 1 < sep.length) && (i + 2 < sep.length)) {
                if (sep[i].equals(first) && sep[i + 1].equals(second)) {
                    res.add(sep[i + 2]);
                }
            }
        }
        String[] result = new String[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findOcurrences("we will we will rock you", "we", "will"));
    }
}
