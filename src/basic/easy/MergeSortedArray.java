package basic.easy;

import java.util.Arrays;

/**
 * Created on 2019/5/20<br>
 *
 * @author dengxingda
 * @version 1.0
 */
public class MergeSortedArray {

    public void merge001(int[] nums1, int m, int[] nums2, int n) {

        System.arraycopy(nums2, 0, nums1, m, n);

        Arrays.sort(nums1);
    }

    /**
     * 从后往前比较，并从后往前插入
     * 在不生成新数组的情况下进行merge sort
     */
    public void merge002(int[] nums1, int m, int[] nums2, int n) {
        int current = m + n - 1;
        int a1 = m - 1;
        int a2 = n - 1;
        while (current >= 0) {
            if (a1 < 0 && a2 >= 0) {
                nums1[current--] = nums2[a2--];
                continue;
            }

            if (a2 < 0 && a1 >= 0) {
                nums1[current--] = nums1[a1--];
                continue;
            }

            if (nums1[a1] > nums2[a2])
                nums1[current--] = nums1[a1--];
            else
                nums1[current--] = nums2[a2--];
        }
    }


}
