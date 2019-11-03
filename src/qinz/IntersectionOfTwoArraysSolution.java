package qinz;

import java.util.HashSet;

public class IntersectionOfTwoArraysSolution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        HashSet<Integer> result = new HashSet<>();
        for(int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])) {
                result.add(nums2[i]);
            }
        }

        int[] arr = new int[result.size()];
        int num = 0;
        for(int element: result) {
            arr[num] = element;
            num++;
        }
        return arr;
    }
}
