package lc001to020.lc009;

/**
 * Created on 2019/2/14<br>
 *
 * @author dengxingda
 * @version 1.0
 */
public class Solution {
    public boolean isPalindrome(int x) {

        if (x < 0) return false;
        if (x < 10) return true;
        if (x % 10 == 0) return false;

        int reverseHalf = 0;
        while (x > reverseHalf) {
            reverseHalf = reverseHalf * 10 + x % 10;
            x /= 10;
        }

        return x == reverseHalf || x == reverseHalf / 10;
    }
}
