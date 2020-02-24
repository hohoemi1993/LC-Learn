package lc058最后一个单词的长度;

public class Solution {
    public int lengthOfLastWord(String s) {
        if (null ==s || "".equals(s)) {
            return 0;
        }
        char[] val = s.trim().toCharArray();
        int len = 0;
        for (int i=val.length - 1; i >= 0; i--) {
            if (val[i] == ' ') {
                return len;
            }
            len++;
        }
        return len;
    }

}
