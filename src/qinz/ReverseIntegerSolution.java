package qinz;

import java.util.Stack;

public class ReverseIntegerSolution {
    public static int reverse(int x) {
        Stack<Integer> remains = new Stack<>();

        // try to avoid the use of toString() and parseInt()
        int temp = x;
        while (temp != 0) {
            int remain = temp % 10;
            temp = temp / 10;
            remains.add(remain);
        }
        int multiply = 1;
        int result = 0;
        boolean trailingZero = true;
        while (!remains.isEmpty()) {
            int pop = remains.pop();
            long test = result + (long)pop * multiply;
            if (test > Integer.MAX_VALUE || test < Integer.MIN_VALUE) {
                return 0;
            }
            result += pop * multiply;
            multiply *= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(120));
    }
}
