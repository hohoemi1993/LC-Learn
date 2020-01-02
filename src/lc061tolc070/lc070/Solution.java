package lc061tolc070.lc070;

/**
 * Created on 2019/3/1<br>
 *
 * @author dengxingda
 * @version 1.0
 */
public class Solution {
    public int climbStairs(int n) {
        if (n < 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int a = 1;
        int b = 1;
        int ans = 0;
        for (int i = 3; i <= n; ++i) {
            ans = a + b;
            a = b;
            b = ans;
        }
        return ans;
    }
}
