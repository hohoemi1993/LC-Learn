package basic.二分查找模板;

/**
 * @author dxd
 * @date 2020/4/7
 */
public class Solution {

  /**
   * 基本二分查找
   */
  int binarySearch(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while(left <= right) {
      // 防止整型溢出
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else if(nums[mid] == target) {
        // 直接返回
        return mid;
      }
    }
    // 直接返回
    return -1;
  }

  /**
   * 寻找左侧边界
   */
  int leftBound(int[] nums, int target) {
    int left = 0, right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else if (nums[mid] == target) {
        // 别返回，锁定左侧边界
        right = mid - 1;
      }
    }
    // 最后要检查 left 越界的情况
    if (left >= nums.length || nums[left] != target) {
      return -1;
    }
    return left;
  }

  /**
   * 寻找右侧边界
   */
  int rightBound(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else if (nums[mid] == target) {
        // 别返回，锁定右侧边界
        left = mid + 1;
      }
    }
    // 最后要检查 right 越界的情况
    if (right < 0 || nums[right] != target) {
      return -1;
    }
    return right;
  }

}
