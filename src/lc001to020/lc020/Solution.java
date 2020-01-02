package lc001to020.lc020;

import java.util.LinkedList;

/**
 * Created on 2019/2/20<br>
 *
 * @author dengxingda
 * @version 1.0
 */
public class Solution {

    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            switch (chars[i]) {
                case '(':
                    stack.push('(');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case '{':
                    stack.push('{');
                    break;
                case ')':
                    if (stack.isEmpty()) return false;
                    if ('(' != stack.pop()) return false;
                    break;
                case ']':
                    if (stack.isEmpty()) return false;
                    if ('[' != stack.pop()) return false;
                    break;
                case '}':
                    if (stack.isEmpty()) return false;
                    if ('{' != stack.pop()) return false;
                    break;
            }

        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}
