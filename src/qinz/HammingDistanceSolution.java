package qinz;

public class HammingDistanceSolution {
    public static int hammingDistance(int x, int y) {
        int hammingDistance = 0;
        while(x != 0 || y != 0) {
            if(x % 2 != y % 2) {
                hammingDistance++;
            }
            x = x >>> 1;
            y = y >>> 1;
        }
        return hammingDistance;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }
}
