package lc767重构字符串;

import java.util.*;

public class Solution {
    public String reorganizeString(String S) {
        int len = S.length();
        if (len < 2) return S;
        int[] frequence = new int[26];
        int maxIndex = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            char c = S.charAt(i);
            int index = c-'a';
            frequence[index]++;
            if (frequence[index] > max) {
                maxIndex = index;
                max = frequence[index];
            }
        }

        if (frequence[maxIndex] > (len+1) / 2) {
            return "";
        }

        PriorityQueue<Character> queue = new PriorityQueue<>(
                Comparator.comparingInt(o -> -frequence[o - 'a'])
        );

        for (int i = 0; i < 26; i++) {
            if (frequence[i] > 0) {
                queue.offer((char) (i+'a'));
            }
        }

        StringBuilder builder = new StringBuilder();
        while (queue.size() > 1) {
            Character letter1 = queue.poll();
            Character letter2 = queue.poll();
            builder.append(letter1);
            builder.append(letter2);
            frequence[letter1 - 'a']--;
            frequence[letter2 - 'a']--;
            if (frequence[letter1 - 'a'] > 0) {
                queue.offer(letter1);
            }
            if (frequence[letter2 - 'a'] > 0) {
                queue.offer(letter2);
            }
        }

        if (!queue.isEmpty()) {
            builder.append(queue.poll());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String aab = solution.reorganizeString("aab");
        System.out.println(aab);
    }

}
