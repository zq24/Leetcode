package qinz;

public class ShortestWayToFormStringSolution {
    public int shortestWay(String source, String target) {
        int numberOfSubseq = 0;
        int startIndex = 0;
        while (startIndex < target.length()) {
            String remainTarget = target.substring(startIndex);
            int lengthFound = shortestWayHelper(source, remainTarget);
            if (lengthFound == 0) {
                return -1;
            } else {
                numberOfSubseq += 1;
            }
            startIndex += lengthFound;
        }
        return numberOfSubseq;
    }

    private int shortestWayHelper(String source, String target) {
        int sourceIndex = 0, targetIndex = 0;
        while (sourceIndex < source.length() && targetIndex < target.length()) {
            if (source.charAt(sourceIndex) == target.charAt(targetIndex)) {
                sourceIndex += 1;
                targetIndex += 1;
            } else {
                sourceIndex += 1;
            }
        }
        return targetIndex;
    }
}
