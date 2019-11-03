package qinz;

public class BeautifulArraySolution {
    public int[] beautifulArray(int N) {
        int[] res = new int[N];
        if (N == 1) {
            res[0] = 1;
            return res;
        }
        res[0] = 1;
        for (int i = 1; i < N; i++) {
            if (i % 2 == 1) {
                res[i] = i + 2;
            } else {
                res[i] = i;
            }
        }
        if (N % 2 == 0) {
            res[N - 1] = N;
        }
        return res;
    }
}
