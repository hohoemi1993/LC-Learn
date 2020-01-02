package dp;

import java.util.Arrays;

/**
 * Created on 2019/3/1<br>
 *
 * @author dengxingda
 * @version 1.0
 */
public class CombinationSumIV {

    private int[] dp;

    public int combinationSum4(int[] nums, int target) {
//        if (target == 0) return 1;
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        // init
        dp[0] = 1;

        return dynamicProgramming(nums, target);
    }

    private int dynamicProgramming(int[] nums, int target) {
        // to avoid duplicate calculate
        if (dp[target] != -1) return dp[target];

        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (target >= nums[i])
                ans += dynamicProgramming(nums, target - nums[i]);
        }

        dp[target] = ans;

        return ans;
    }
}
