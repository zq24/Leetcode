package qinz;

public class DefangingAnIPAddressSolution {
    public String defangIPaddr(String address) {
        int first = address.indexOf('.');
        int second = address.indexOf('.', first + 1);
        int third = address.indexOf('.', second + 1);
        String result = address.substring(0, first) + "[.]" +
                address.substring(first + 1, second) + "[.]" +
                address.substring(second + 1, third) + "[.]" +
                address.substring(third + 1);
        return result;
    }
}
