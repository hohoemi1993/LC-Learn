package lc327区间和的个数;

import java.util.HashMap;

public class Solution {
  public int countRangeSumExceedTime(int[] nums, int lower, int upper) {
    int n = nums.length;
    int count = 0;
    HashMap<Integer, Long> memory =  new HashMap<>();
    for (int i = 0; i < n; i++) {
      HashMap<Integer, Long> newMemory = new HashMap<>(2* (n - i));
      for (int j = 0; j < n-i; j++) {
        if (0==i) {
          newMemory.put(j, nums[j] +0L);
          if (nums[j] <= upper && nums[j] >= lower) {
            count++;
          }
        } else {
          Long sj = memory.get(j);
          long sum = sj + nums[j + i];
          newMemory.put(j, sum);
          if (sum <= upper && sum >= lower) {
            count++;
          }
        }
      }
      memory = newMemory;
    }
    return count;
  }


  public int countRangeSum(int[] nums, int lower, int upper) {
    long s = 0;
    // 前缀和数组
    // 注意: preSum(1) - preSum(0) = S(1,1)
    //       因此前缀和数组长度需要+1
    long[] sum = new long[nums.length + 1];
    for (int i = 0; i < nums.length; ++i) {
      s += nums[i];
      sum[i + 1] = s;
    }
    return countRangeSumRecursive(sum, lower, upper, 0, sum.length - 1);
  }

  public int countRangeSumRecursive(long[] sum, int lower, int upper, int left, int right) {
    // 递归出口
    if (left == right) {
      return 0;
    }
    else {
      int mid = (left + right) / 2;
      int n1 = countRangeSumRecursive(sum, lower, upper, left, mid);
      int n2 = countRangeSumRecursive(sum, lower, upper, mid + 1, right);
      int ret = n1 + n2;

      // 首先统计下标对的数量
      int i = left;
      int l = mid + 1;
      int r = mid + 1;
      // 这里 left - mid 是升序的数组n1
      // mid + 1 - right 是升序的数组n2
      while (i <= mid) {
        while (l <= right && sum[l] - sum[i] < lower) {
          l++;
        }
        while (r <= right && sum[r] - sum[i] <= upper) {
          r++;
        }
        ret += r - l;
        i++;
      }

      // 随后合并两个排序数组
      int[] sorted = new int[right - left + 1];
      int p1 = left, p2 = mid + 1;
      int p = 0;
      while (p1 <= mid || p2 <= right) {
        if (p1 > mid) {
          sorted[p++] = (int) sum[p2++];
        } else if (p2 > right) {
          sorted[p++] = (int) sum[p1++];
        } else {
          if (sum[p1] < sum[p2]) {
            sorted[p++] = (int) sum[p1++];
          } else {
            sorted[p++] = (int) sum[p2++];
          }
        }
      }
      for (int j = 0; j < sorted.length; j++) {
        sum[left + j] = sorted[j];
      }
      return ret;
    }
  }





  public static void main(String[] args) {

    int[] nums = new int[] {-2147483647,0,-2147483647,2147483647};
    int lower = -564;
    int upper = 3864;

    Solution solution = new Solution();
    int count = solution.countRangeSum(nums, lower, upper);
    System.out.println(count);
  }
}
