package lc001to020.lc016;

import java.util.Arrays;

/**
 * Created on 2019/2/18<br>
 *
 * @author dengxingda
 * @version 1.0
 */
public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) return 0;
        int result = nums[0] + nums[1] + nums[nums.length -1];
        Arrays.sort(nums);

        for(int i = 0;i < nums.length -2; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) continue;

            int low = i+1;
            int high = nums.length - 1;

            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == target) return sum;
                if (sum < target) ++low;
                else --high;
                if (Math.abs(sum - target) < Math.abs(result - target)){
                    result = sum;
                }
            }
        }
        return result;
    }

}
