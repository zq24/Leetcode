package qinz;

public class MultiplyStringsSolution {
    public String multiply(String num1, String num2) {
        int n1 = 0, n2 = 0;
        for (int i = 0; i < num1.length(); i++) {
            n1 = (n1 * 10) + num1.charAt(i) - '0';
        }
        for (int i = 0; i < num2.length(); i++) {
            n2 = (n2 * 10) + num2.charAt(i) - '0';
        }
        return Integer.toString(n1 * n2);
    }
}
