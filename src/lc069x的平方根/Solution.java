package lc069x的平方根;

/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author dxd
 * @date 2020/4/7
 */
public class Solution {
  public int mySqrt(int x) {
    // 边界值判断
    if (x < 2) {
      return x;
    }
    // 设置搜索区间
    long left = 1;
    long right = x / 2;
    while (left < right) {
      // 为什么加1
      //
      long mid = (left + right) / 2 + 1;

     if (mid * mid > x) {
        right = mid - 1;
      }
      else {
        left = mid;
      }
    }
    return (int) left;
  }
}
