package dp.凑零钱;

/**
 * @author dxd
 * @date 2020/5/9
 */
public class Solution {

  public int toChange(int amount, int[] coins) {
    if (amount < 0) return -1;
    if (amount == 0) return 0;

    int temp = Integer.MAX_VALUE;
    for (int coin : coins) {
      int sub = toChange(amount - coin, coins);
      if (-1 == sub) continue;
      temp = Math.min(temp, sub + 1);
    }
    return temp;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] coins = {1,2,5};
    int min = solution.toChange(21, coins);
    System.out.println(min);
  }

}
