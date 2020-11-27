package lc164最大间距;

import java.util.Arrays;

public class Solution2 {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        Arrays.sort(nums);
        int maxGap = 0;
        for (int i = 1; i < nums.length; i++) {
            Math.max(maxGap, nums[i]-nums[i-1]);
        }


        return maxGap;

    }


}
