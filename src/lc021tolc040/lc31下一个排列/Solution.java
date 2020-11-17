package lc021tolc040.lc31下一个排列;

import javax.xml.transform.SourceLocator;
import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 1;
        for (; i>0; i--) {
            if (nums[i] > nums[i-1]) {
                i--;
                break;
            }
        }
        int j = len-1;
        for (; j > i; j--) {
            if (nums[j] > nums[i]) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                next(nums, i);
                return;
            }
        }

        next(nums, -1);
    }

    private void next(int[] nums, int i) {

        // 冒泡排序
        int len = nums.length;
        for (int k = i+1; k < len - 1; k++) {
            for (int l = k + 1; l < len; l++) {
                if (nums[k] > nums[l]) {
                    int t = nums[k];
                    nums[k] = nums[l];
                    nums[l] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = new int[] {3,2,1};
//        int[] nums = new int[] {1,2,3};
//        int[] nums = new int[] {1,3,2};
//        int[] nums = new int[] {4,2,0,2,3,2,0};
        int[] nums = new int[]  {100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82,81,80,79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};

        solution.nextPermutation(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
