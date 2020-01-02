package basic.easy;

/**
 * Created on 2019/5/5<br>
 *
 * @author dengxingda
 * @version 1.0
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }
}
