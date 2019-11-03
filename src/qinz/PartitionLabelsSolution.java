package qinz;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabelsSolution {
    public static List<Integer> partitionLabels(String S) {
        //traverse the entire string and record the last index appeared of each char
        List<Integer> partition = new ArrayList<>();
        int[] map = new int[26];
        for (int i = 0; i < S.length(); i++) {
            map[S.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        for(int i = 0; i < S.length(); i++) {
            if(map[S.charAt(i) - 'a'] > end) {
                end = map[S.charAt(i) - 'a'];
            }
            if(i == end) {
                partition.add(S.substring(start, end + 1).length());
                start = end + 1;
            }
        }
        return partition;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}
