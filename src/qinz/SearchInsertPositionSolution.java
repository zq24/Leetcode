package qinz;

import java.util.Arrays;

public class SearchInsertPositionSolution {
    public static int searchInsert(int[] nums, int target) {
        /*int index = Arrays.binarySearch(nums, target);
        return (index < 0) ? -1 * (index + 1) : index;*/
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        /*System.out.println("Low: " + lo);
        System.out.println("High: " + hi);*/
        return lo;
    }

    public static void main(String[] args) {
        int[] test = new int[] {1, 3, 5, 6};
        System.out.println(searchInsert(test, 0));
    }
}
