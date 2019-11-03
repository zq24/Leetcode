package qinz;

public class AddBinarySolution {
    public static String addBinary(String a, String b) {
        boolean carry = false;
        StringBuilder res = new StringBuilder();
        int lengthStringA = a.length();
        int lengthStringB = b.length();
        int length = (lengthStringA <= lengthStringB) ? lengthStringA : lengthStringB;
        String shorterStr = (lengthStringA <= lengthStringB) ? a : b;
        String longerStr = (lengthStringA <= lengthStringB) ? b.substring(b.length() - length) : a.substring(a.length() - length);
        for (int i = length - 1; i >= 0; i--) {
            if (shorterStr.charAt(i) == '1' && longerStr.charAt(i) == '1') {
                if (carry) {
                    res.insert(0, 1);
                    carry = true;
                } else {
                    res.insert(0, 0);
                    carry = true;
                }
            } else if (shorterStr.charAt(i) == '1' && longerStr.charAt(i) == '0') {
                if (carry) {
                    res.insert(0, 0);
                    carry = true;
                } else {
                    res.insert(0, 1);
                    carry = false;
                }
            } else if (shorterStr.charAt(i) == '0' && longerStr.charAt(i) == '1') {
                if (carry) {
                    res.insert(0, 0);
                    carry = true;
                } else {
                    res.insert(0, 1);
                    carry = false;
                }
            } else {
                if (carry) {
                    res.insert(0, 1);
                    carry = false;
                } else {
                    res.insert(0, 0);
                    carry = false;
                }
            }
        }

        int longer = Math.abs(lengthStringA - lengthStringB);
        String remain = (lengthStringA >= lengthStringB) ? a.substring(0, longer) : b.substring(0, longer);
        for (int i = longer - 1; i >= 0; i--) {
            if (remain.charAt(i) == '1') {
                if (carry) {
                    res.insert(0, 0);
                } else {
                    res.insert(0, 1);
                    carry = false;
                }
            } else {
                if (carry) {
                    res.insert(0, 1);
                    carry = false;
                } else {
                    res.insert(0, 0);
                    carry = false;
                }
            }
        }

        if (carry) {
            res.insert(0, 1);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        //10 + 11
        System.out.println(addBinary("100", "110010"));
    }
}
