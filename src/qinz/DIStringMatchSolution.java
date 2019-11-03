package qinz;

public class DIStringMatchSolution {
    public int[] diStringMatch(String S) {
        int[] res = new int[S.length() + 1];
        int left = 0;
        int right = S.length();
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == 'D') {
                res[i] = right--;
            } else {
                res[i] = left++;
            }
        }
        res[S.length()] = right;
        return res;
    }
}
