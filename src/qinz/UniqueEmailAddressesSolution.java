package qinz;

import java.util.HashSet;

public class UniqueEmailAddressesSolution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < emails.length; i++) {
            //split the email string using the @ sign
            int indexOfAt = emails[i].indexOf('@');
            //find the plus sign first
            int indexOfPlus = emails[i].indexOf('+');
            String newEmail;
            if(indexOfPlus == -1 || indexOfPlus >indexOfAt) {
                newEmail = emails[i];
            } else {
                //ignore the everything after the first plus sign
                newEmail = emails[i].substring(0, indexOfPlus) + emails[i].substring(indexOfAt);
            }
            String firstHalfNewEmail = newEmail.substring(0, newEmail.indexOf('@'));
            String secondHalfNewEmail = newEmail.substring(newEmail.indexOf('@'));
            set.add(firstHalfNewEmail.replace(".", "") + secondHalfNewEmail);
        }
        return set.size();
    }
}
