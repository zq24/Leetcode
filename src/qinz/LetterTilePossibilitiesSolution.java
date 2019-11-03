package qinz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LetterTilePossibilitiesSolution {
    public static int numTilePossibilities(String tiles) {
        Set<String> res = new HashSet<>();
        //Generate a list of letters from the given String
        List<String> listOfLetter = new ArrayList<>();
        for (int i = 0; i < tiles.length(); i++) {
            listOfLetter.add(tiles.substring(i ,i + 1));
        }
        numTilePossibilities(listOfLetter, tiles, res, "");
        return res.size();
    }

    private static void numTilePossibilities(List<String> letterList, String tiles, Set<String> res, String current) {
        if (current.length() <= tiles.length() && current != "") {
            res.add(current);
        }

        for (int i = 0; i < letterList.size(); i++) {
            String newPossible = current + letterList.get(i);
            String temp = letterList.get(i);
            letterList.remove(i);
            numTilePossibilities(letterList, tiles, res, newPossible);
            letterList.add(i, temp);
        }
    }

    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAABBC"));
    }
}
