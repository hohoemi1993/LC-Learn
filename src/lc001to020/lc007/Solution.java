package lc001to020.lc007;

/**
 * Created on 2019/2/13<br>
 *
 * @author dengxingda
 * @version 1.0
 */
public class Solution {

    /**
     * reverse
     * first thinking should be using stack pop and push
     * attention! Integer.MAX_VALUE > reversed x > Integer.MIN_VALUE
     */
    public int reverse001(int x) {

        if (-10 < x && x < 10) return x;

        int a = x < 0 ? -x : x;
        long reverse = 0;

        while (a > 0) {
            reverse = reverse * 10 + a % 10;
            a = a / 10;
        }

        if (reverse > Integer.MAX_VALUE || -reverse < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) (x < 0 ? -reverse : reverse);
    }
}
