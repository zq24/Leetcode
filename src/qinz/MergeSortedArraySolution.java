package qinz;

public class MergeSortedArraySolution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int totalInitialized = m + n;
        int compareM = m - 1;
        int compareN = n - 1;
        for (int i = totalInitialized - 1; i >= 0; i--) {
            if (compareM == -1 || compareN == -1) {
                nums1[i] = (compareM == -1) ? nums2[compareN--] : nums1[compareM--];
            } else if (nums1[compareM] >= nums2[compareN]) {
                nums1[i] = nums1[compareM];
                compareM--;
            } else {
                nums1[i] = nums2[compareN];
                compareN--;
            }
        }
    }

    public static void main(String[] args) {
        int[] test1 = new int[] {1, 2, 3, 0, 0, 0};
        int[] test2 = new int[] {4, 5, 6};
        merge(test1, 3, test2, 3);
    }
}
