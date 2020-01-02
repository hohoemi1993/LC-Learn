package dp;

import java.util.Arrays;

/**
 * Created on 2019/3/1<br>
 *
 * @author dengxingda
 * @version 1.0
 */
public class CountingBits {

    /**
     * dp
     */
    public int[] countBits(int num) {
        if (num == 0) return new int[]{0};
        if (num == 1) return new int[]{0, 1};

        int[] ans = new int[num + 1];
        Arrays.fill(ans, -1);
        // init
        ans[0] = 0;
        ans[1] = 1;
        for (int i = 2; i < num + 1; ++i) {
            dp(ans, i);
        }
        return ans;
    }

    private int dp(int[] ans, int n) {
        if (ans[n] != -1) return ans[n];
        int m = n;
        int a = 1;

        int bSize = (int) (Math.log(n) / Math.log(2));

        while ((n = (int) (n - Math.pow(2, bSize))) > 0) {
            a += dp(ans, n);
        }

        ans[m] = a;
        return a;
    }

    /**
     * niubility
     */
    public int[] countBits001(int num) {
        int[] ans = new int[num + 1];
        ans[0] = 0;
        for (int i = 1; i < num + 1; ++i)
            ans[i] = ans[i >> 1] + (i & 1);
        return ans;
    }
}
