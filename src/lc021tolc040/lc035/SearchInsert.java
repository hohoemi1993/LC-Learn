package lc021tolc040.lc035;

/**
 * Created on 2019/5/9<br>
 *
 * @author dengxingda
 * @version 1.0
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        return biSearch(nums, target, 0, nums.length - 1);
    }

    private int biSearch(int[] nums, int target, int start, int end) {
        if (start >= end) return start;

        int mid = (end + start) / 2;
        int key = nums[mid];
        if (target > key) {
            return biSearch(nums, target, mid, end);
        } else if (target < key) {
            return biSearch(nums, target, start, mid);
        } else {
            return mid;
        }
    }
}
