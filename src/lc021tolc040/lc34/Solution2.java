package lc021tolc040.lc34;

public class Solution2 {
    // 二分查找
    public int[] searchRange(int[] nums, int target) {
        // 查找第一个目标值的下标
        int leftIdx = binarySearch(nums, target, true);
        // 查找第一个大于目标值的下标 - 1
        int rightIdx = binarySearch(nums, target, false) - 1;
        // 校验
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

}