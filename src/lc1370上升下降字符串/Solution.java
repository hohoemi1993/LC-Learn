package lc1370上升下降字符串;

public class Solution {
    public String sortString(String s) {
        int[] frequence = new int[26];
        for (int i = 0; i < s.length(); i++) {
            frequence[s.charAt(i) - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        boolean up = true;
        for (int i = 0, j=0; i < s.length();) {
            if (frequence[j] != 0) {
                builder.append((char) (j + 'a'));
                frequence[j]--;
                i++;
            }
            if (up) {
                j++;
            } else {
                j--;
            }
            if ( !up && j == -1 ) {
                up  = true;
                j++;
            }
            if (up && j == 26 ) {
                up =  false;
                j--;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = solution.sortString("aaaabbbbcccc");
        System.out.println(a);
    }
}
