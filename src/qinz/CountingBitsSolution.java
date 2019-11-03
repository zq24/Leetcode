package qinz;

public class CountingBitsSolution {
    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        for(int i = 0; i <= num; i++) {
            int numOfBits = 0;
            int temp = i;
            while(temp != 0) {
                if((temp & 1) != 0) {
                    numOfBits++;
                }
                temp = temp >> 1;
            }
            result[i] = numOfBits;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countBits(2));
    }

}
