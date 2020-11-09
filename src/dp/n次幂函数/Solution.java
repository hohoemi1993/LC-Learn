package dp.n次幂函数;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dxd
 * @date 2020/5/11
 */
public class Solution {

  public double myPow(double x, int n) {
    if (x == 0) return 0;
    if (x == 1) return 1;
    if (n == 0) return 1;
    if (n == -1) return 1/x;
    if (n < 0) {
      x = 1/x;
      n = -n;
    }

    // n -> 二进制, 例如 10 = 1010



    double[] dp = new double[n];
    dp[0] = 1;
    dp[1] = x;

    for (int i = 2; i < n; i++) {
      if (i%2 == 0) {
        dp[i] = dp[i / 2] * dp[i / 2];
      }
      else {
        dp[i] = dp[i / 2] * dp[i / 2] * x;
      }
    }
    return  dp[n -1] * x;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    double v = solution.myPow(2 ,3);
    System.out.println(v);
  }


}
