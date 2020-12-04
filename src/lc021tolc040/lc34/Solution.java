package lc021tolc040.lc34;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        if (null == nums || nums.length < 1) {
            return new int[]{start, end};
        }
        int left = 0;
        int right = nums.length -1;
        boolean notFound = true;
        while (notFound) {

            while (left <= right && nums[left] != target)
                left++;
            if (left <= right && nums[left] == target)
                start = left;
                notFound = false;

            while (left <= right && nums[right] != target)
                right--;
            if (left <= right && nums[right] == target)
                end = right;
            if (left >= right) {
                break;
            }
        }
        return new int[]{start, end};
    }

}