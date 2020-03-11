package lc001to020.lc014最长公共前缀;

/**
 * Created on 2019/2/15<br>
 *
 * @author dengxingda
 * @version 1.0
 */
public class Solution {
    /**
     * easy
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) return "";
        char c;
        StringBuilder result = new StringBuilder();
        String s = strs[0];
        for (int i = 0; i < s.length(); ++i) {
            c = s.charAt(i);
            for (String str : strs) {
                if (str.length() == i) return result.toString();
                if (str.charAt(i) != c) return result.toString();
            }
            result.append(s.charAt(i));
        }
        return result.toString();
    }
}
