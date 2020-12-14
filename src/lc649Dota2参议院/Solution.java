package lc649Dota2参议院;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new ArrayDeque<>();
        Queue<Integer> dire = new ArrayDeque<>();
        for (int i = 0; i < senate.length(); i++) {
            char s = senate.charAt(i);
            if ('R' == s) {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            Deque<Integer> radiantNew = new ArrayDeque<>();
            Deque<Integer> direNew = new ArrayDeque<>();
            while (!radiant.isEmpty() && !dire.isEmpty()) {
                Integer r = radiant.poll();
                Integer d = dire.poll();
                if (r > d) {
                    direNew.offer(d);
                } else {
                    radiantNew.offer(r);
                }
            }
            while (!radiant.isEmpty() && !direNew.isEmpty()) {
                radiantNew.offer(radiant.poll());
                direNew.remove();
            }
            while (!dire.isEmpty() && !radiantNew.isEmpty()) {
                direNew.offer(dire.poll());
                radiantNew.remove();
            }
            radiant = radiantNew;
            dire = direNew;
        }

        String ans = "Radiant";
        if (!radiant.isEmpty()) {
            ans = "Radiant";
        }
        if (!dire.isEmpty()) {
            ans = "Dire";
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String rrddd = solution.predictPartyVictory("RDD");
        System.out.println(rrddd);
    }
}
