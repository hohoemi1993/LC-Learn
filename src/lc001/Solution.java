package lc001;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2019/2/11<br>
 *
 *
 * @author dengxingda
 * @version 1.0
 */
public class Solution {
    /**
     * brute force
     * T: O(n^2)  S: O(1)
     */
    public int[] twoSum001(int[] nums, int target) {
        int temp;
        for(int i = 0 ; i < nums.length; ++i){
            temp = target - nums[i];
            for(int j = 0; j < nums.length ;++j){
                if( i != j && temp == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * two-pass hash table
     * T: O(n) S: O(n)
     */
    public int[] twoSum002(int[] nums, int target) {
        // add elements into a hash map { value : index}
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        for (int i=0; i < nums.length; ++i){
            map.put(nums[i],i);
        }

        // finding the indices
        int temp;
        for (int i=0; i < nums.length; ++i){
            temp = target - nums[i];
            if(map.containsKey(temp) && map.get(temp) != i){
                return new int[] {i,map.get(temp)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * one-pass hash table
     * T: O(n) S: O(n)
     */
    public int[] twoSum003(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        int temp;
        for (int i=0; i < nums.length; ++i){
            temp = target - nums[i];
            // check back
            if(map.containsKey(temp)){
                return new int[] {map.get(temp),i};
            }

            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
