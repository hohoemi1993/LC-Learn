package lc003;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created on 2019/2/11<br>
 *
 *
 *
 * @author dengxingda
 * @version 1.0
 */
public class Solution {

    /**
     * brute force
     * T: O(n^3)
     * Space complexity : O(min(n,m)).
     */
    public int lengthOfLongestSubstring001(String s) {
        int n = s.length();
        int ans = 0;
        // 0 <= i < j <= n
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                Set<Character> set = new HashSet<>();
                boolean flag = true;
                for (int k = i; k < j; k++) {
                    Character ch = s.charAt(k);
                    if (set.contains(ch))
                        flag = false;
                    set.add(ch);
                }
                if (flag){
                    ans = Math.max(ans,j-i);
                }

            }
        }
        return ans;
    }

    /**
     * Sliding Window [i,j)
     * T: O(2n)
     */
    public int lengthOfLongestSubstring002(String s) {
        Set<Character> slide = new HashSet<>(256);
        int len = s.length();
        int i = 0;
        int j = 0;
        int ans = 0;
        while(i<len && j<len){

            if(slide.contains(s.charAt(j))){
                slide.remove(s.charAt(i));
                ++i;
            }
            else {
                slide.add(s.charAt(j));
                j++;
                ans = Math.max(ans,j-i);
            }
        }
        return ans;
    }

    /**
     * Sliding Window Optimized
     * by using hash map char:index
     * T: O(n)
     *
     */
    public int lengthOfLongestSubstring003(String s) {
        Map<Character,Integer> slide = new HashMap<>(256);
        int len = s.length();
        int i = 0;
        int j = 0;
        int ans = 0;
        while (i<len && j<len) {
            if(slide.containsKey(s.charAt(j))){
                i = Math.max(i, slide.get(s.charAt(j)) + 1);
            }
            slide.put(s.charAt(j),j);
            // log the max size of sliding window
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }

    /**
     * same as 003
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
