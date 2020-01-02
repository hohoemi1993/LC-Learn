package lc021tolc040.lc027;

/**
 * Created on 2019/5/6<br>
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length
 *
 * @author dengxingda
 * @version 1.0
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int j = nums.length - 1;
        int i = 0;
        while (i <= j) {
            if (nums[i] == val) {
                nums[i] = nums[j];
                j--;
            } else {
                i++;
            }
        }

        return i;
    }
}
