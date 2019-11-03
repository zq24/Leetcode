package qinz;

public class ToLowerCaseSolution {
    public String toLowerCase(String str) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                res.append((char) (str.charAt(i) + 32));
            } else {
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println((char)('Z' + 32));
    }
}
