package lc389找不同;

public class Solution {
    public char findTheDifference(String s, String t) {
        int[] bucketS = new int[26];
        int[] bucketT = new int[26];
        for (int i = 0; i < s.length(); i++) {
            bucketS[s.charAt(i) - 'a']++;
            bucketT[t.charAt(i) - 'a']++;
        }
        bucketT[t.charAt(s.length()) - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (bucketS[i] != bucketT[i]) {
                return (char) (i + 'a');
            }
        }
        return 'a';
    }
}
