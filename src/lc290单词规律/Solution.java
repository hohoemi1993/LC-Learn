package lc290单词规律;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (map1.containsKey(pattern.charAt(i))) {
                String word = map1.get(pattern.charAt(i));
                if (!words[i].equals(word)) return false;
            }
            else if (map2.containsKey(words[i])) {
                Character character = map2.get(words[i]);
                if (character != pattern.charAt(i)) return false;

            } else {
                map1.put(pattern.charAt(i), words[i]);
                map2.put(words[i], pattern.charAt(i));
            }
        }
        return true;
    }
}
