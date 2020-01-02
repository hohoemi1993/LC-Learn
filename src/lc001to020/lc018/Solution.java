package lc001to020.lc018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 2019/2/19<br>
 *
 * @author dengxingda
 * @version 1.0
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (null == nums || nums.length < 4) return ans;

        Arrays.sort(nums);

        if (nums[0] << 2 > target || nums[nums.length - 1] << 2 < target) return ans;

        for (int i = 0; i < nums.length - 3; ++i) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int threeSum = target - nums[i];

            for (int j = i + 1; j < nums.length - 2; ++j) {

                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int low = j + 1;
                int high = nums.length - 1;
                int sum = threeSum - nums[j];
                while (low < high) {

                    if (sum == nums[low] + nums[high]) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while (low < high && nums[high] == nums[high - 1]) --high;
                        --high;
                        while (low < high && nums[low] == nums[low + 1]) ++low;
                        ++low;
                    } else if (sum < nums[low] + nums[high]) {
                        while (low < high && nums[high] == nums[high - 1]) --high;
                        --high;
                    } else {
                        while (low < high && nums[low] == nums[low + 1]) ++low;
                        ++low;
                    }

                }
            }

        }
        return ans;
    }
}
