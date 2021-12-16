package lc377组合总和Ⅳ;

public class Solution {
  /**
   * 状态 dp[target] = 组合个数
   * 转移方程： dp[i] = dp[i] + dp[i - num]
   * 初始条件 dp[0] = 1
   */
  public int combinationSum4(int[] nums, int target) {
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for (int i = 0; i <= target; i++) {
      for (int num : nums) {
        if (i >= num) {
          dp[i] = dp[i] + dp[i - num];
        }
      }
    }

    return dp[target];
  }

}
