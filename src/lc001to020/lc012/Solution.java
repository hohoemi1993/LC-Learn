package lc001to020.lc012;

/**
 * Created on 2019/2/15<br>
 *
 * @author dengxingda
 * @version 1.0
 */
public class Solution {
    /**
     * boring
     */
    public String intToRoman(int num) {
        // 1000 2000 3000
        String M[] = {"", "M", "MM", "MMM"};
        // 100 - 900 step 100
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        // 10 - 90 step 10
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        // 0-9
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }
}
