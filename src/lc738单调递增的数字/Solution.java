package lc738单调递增的数字;

public class Solution {
    public int monotoneIncreasingDigits(int N) {
        // N [0, 10^9]
        String nums = N + "";
        // 高位在末尾
        char[] chars = nums.toCharArray();
        for (int i = 0; i < nums.length() - 1; i++) {
            if (nums.charAt(i) -'0' > nums.charAt(i+1) -'0') {
                while (i > 0 && chars[i] == chars[i-1]) {
                    i--;
                }
                chars[i] = (char) (chars[i] - 1);
                for (int j = i + 1; j < nums.length(); j++) {
                    chars[j] = '9';
                }
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.monotoneIncreasingDigits(10);
        System.out.println(i);
    }
}
