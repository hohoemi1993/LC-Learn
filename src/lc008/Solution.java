package lc008;

/**
 * Created on 2019/2/13<br>
 *
 * @author dengxingda
 * @version 1.0
 */
public class Solution {
    /**
     * boring
     */
    public int myAtoi001(String str) {
        char[] chars = str.trim().toCharArray();
        if (chars.length == 0) return 0;
        int index = 0;
        boolean neg = false;

        if(chars[index] == '+') {
            ++index;
        }

        else if (chars[index] == '-') {
            neg = true;
            ++index;
        }

        long result  = 0;

        for (;index < chars.length; ++index){
            if (chars[index] == ' ' || chars[index] == '.')
                break;
            if (chars[index] - 48 > 9 || chars[index] - 48 < 0)
                break;
            result = result * 10 + chars[index] - 48;
            if (result > Integer.MAX_VALUE) {
                if (neg)  return Integer.MIN_VALUE;
                return Integer.MAX_VALUE;
            }
        }

        if (neg) result = -result;

        return (int) result;
    }
}
