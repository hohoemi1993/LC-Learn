package lc198打家劫舍;

public class Solution {
  //dp [i] 偷当前房间累计获得的金钱数
  // dp[i] = Math.max(dp[i - 2],dp[i-3]) + nums[i]
  public int rob(int[] nums) {
    int len = nums.length;
    if (len == 0) return 0;
    if (len == 1) return nums[0];
    if (len == 2) return Math.max(nums[len-1], nums[len-2]);
    int[] dp = new int[len];
    dp[0] = nums[0];
    dp[1] = nums[1];
    dp[2] = dp[0] + nums[2];

    for (int i =3 ; i<len; i++) {
      dp[i]  = Math.max(dp[i - 2],dp[i-3]) + nums[i];
    }
    return  Math.max(dp[len-1], dp[len-2]);
  }
}
