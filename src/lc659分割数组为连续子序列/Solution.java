package lc659分割数组为连续子序列;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    /**
     * hash + 最小堆
     * @param nums
     * @return
     */
    public boolean isPossible(int[] nums) {

        // 以 Integer 结尾的子序列有 PriorityQueue<Integer> 个
        // 且长度为其中的元素的值
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                PriorityQueue<Integer> queue =  new PriorityQueue<>();
                map.put(nums[i], queue);
            }
            if (!map.containsKey(nums[i]-1)) {
                map.get(nums[i]).offer(1);
            } else {
                int prevLength = map.get(nums[i] - 1).poll();
                if (map.get(nums[i] - 1).isEmpty()) {
                    map.remove(nums[i] -1);
                }
                map.get(nums[i]).offer(prevLength +1);
            }
        }
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            if (entry.getValue().peek() < 3) {
                return false;
            }
        }
        return true;
    }
}
