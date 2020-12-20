package lc316去除重复字母;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
  public String removeDuplicateLetters(String s) {
    int[] f = new int[26];
    char[] chars = s.toCharArray();
    for (char c : chars) {
      f[c-'a']++;
    }
    Set<Character> visited = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    char temp;
    for (char c : chars) {
      while (sb.length() > 0
          && (temp = sb.charAt(sb.length() - 1)) > c
          && f[temp-'a'] > 0
          && !visited.contains(c)) {
        sb.deleteCharAt(sb.length() - 1);
        visited.remove(temp);
      }
      if (!visited.contains(c)) {
        sb.append(c);
        visited.add(c);
      }
      f[c-'a']--;
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String one = solution.removeDuplicateLetters("abacb");
    System.out.println(one);
  }
}
