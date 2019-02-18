package lc001to020.lc015;

import java.util.*;

/**
 * Created on 2019/2/18<br>
 *
 * @author dengxingda
 * @version 1.0
 */
public class Solution {

    public List<List<Integer>> threeSum001(int[] nums) {
        if (nums.length < 3) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        // sort
        Arrays.sort(nums);
        // iterate nums small to large
        int low;
        int high;
        int sum;
        // n
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0; i < nums.length; ++i){
            map.put(nums[i],i);
        }
        // n^2
        for (int i=0 ; i < nums.length ; ++i){
            // avoid repeated integer
            if (i > 0 && nums[i] == nums[i-1]) continue;
            // two sum
            high = nums.length;
            sum = - nums[i];
            for (low = i + 1 ; low < high ; ++low) {
                int temp = sum - nums[low];
                if (map.containsKey(temp) && map.get(temp) > low) {
                    List<Integer> l = Arrays.asList(nums[i],nums[low],nums[map.get(temp)]);
                    // may cost 3n
                    if (result.contains(l)) continue;
                    result.add(l);
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum002(int[] nums) {
        if (nums.length < 3) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int low;
        int high;
        int sum;
        for (int i=0; i < nums.length - 2; ++i) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            // iterate nums small to large
            low = i + 1;
            high = nums.length - 1;
            sum = -nums[i];
            while (low < high) {
                if(nums[low] + nums[high] == sum ) {
                    result.add(Arrays.asList(nums[i], nums[low++], nums[high--]));
                    while (low < high && nums[low] == nums[low - 1]) ++low;
                    while (low < high && nums[high] == nums[high + 1]) --high;
                }
                else if(nums[low] + nums[high] < sum) ++low;
                else --high;
            }
        }
        return result;
    }

}
