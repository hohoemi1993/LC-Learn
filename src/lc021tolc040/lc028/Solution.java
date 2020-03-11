package lc021tolc040.lc028;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created on 2019/3/5<br>
 *
 * @author dengxingda
 * @version 1.0
 */
public class Solution {
    public int strStr(String haystack, String needle) {

        if (haystack == null || needle == null) return -1;

        int tLen = needle.length();
        int sLen = haystack.length();
        if (tLen > sLen) return -1;
        if (0 == tLen) return 0;

        // kmp
        char[] t = needle.toCharArray();
        int[] next = new int[tLen];
        // next[]
        int i = 0;
        int j = -1;
        next[0] = -1;
        while (i < tLen - 1) {
            if (j == -1 || t[i] == t[j]) {
                ++i;
                ++j;
                if (t[i] == t[j])
                    next[i] = next[j];
                else
                    next[i] = j;
            } else {
                j = next[j];
            }
        }
        // match
        char[] s = haystack.toCharArray();
        i = 0;
        j = 0;
        while (i < sLen && j < tLen) {
            if (j == -1 || s[i] == t[j]) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }

        if (j < tLen) return -1;
        else return i - tLen;
    }
}
