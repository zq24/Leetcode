package qinz;

public class CountAndSaySolution {
    public static String countAndSay(int n) {
        String previous = "1";
        if(n == 1) {
            return "1";
        } else {
            return countAndSay(n, previous, 1);
        }
    }

    private static String countAndSay(int n, String previous, int current) {
        String result = "";
        if(current == n) {
            return previous;
        } else {
            int continuous = 1;
            for(int i = 0; i < previous.length(); i++) {
                if(i != previous.length() - 1) {
                    if (previous.charAt(i) == previous.charAt(i + 1)) {
                        continuous++;
                    } else {
                        result += continuous + previous.substring(i, i + 1);
                        continuous = 1;
                    }
                } else {
                    result += continuous + previous.substring(i, i + 1);
                }
            }
        }
        current++;
        result = countAndSay(n, result, current);
        return  result;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }
}
