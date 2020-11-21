package lc402移掉K位数字;

import java.util.Arrays;

public class Solution {

  public String removeKdigits(String num, int k) {
    if (k <= 0) return num;
    int len = num.length();
    if (len == k ) return "0";
    char[] nums = num.toCharArray();
    if (len - k == 1) {
      char res = nums[0];
      for (int i=1; i<len; i++) {
        if (res > nums[i]) {
          res = nums[i];
        }
      }
      return res + "";
    }
    char[] res = new char[len-k];


    System.arraycopy(nums, 0, res, 0, len-k);

    // 自高位向低位
    for (int i = len-k; i < len; i++) {
      // 这里默认了res至少长度为2
      for(int j=0; j < res.length ; j++) {
        if (j == res.length-1 && res[j] > nums[i]) {
          move(res, j, nums[i]);
          break;
        }
        // 自高位向低位寻找第一个极大值
        if (j < res.length-1 && res[j] > res[j+1]) {
          // 去除
          move(res, j, nums[i]);
          break;
        }
      }
    }
    // 去除前导0
    int start = 0;
    while (start < res.length && res[start] == '0') {
      start++;
    }
    if (start == res.length) return "0";
    return new String(res).substring(start, res.length);
  }

  private void move(char[] res, int start, char end) {
    for (int i = start; i < res.length - 1; i++) {
      res[i] = res[i+1];
    }
    res[res.length - 1] = end;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    String s = solution.removeKdigits("112",1);
//    String s = solution.removeKdigits("9999999999991", 8);

//    String s = solution.removeKdigits("100", 1);

//    String s = solution.removeKdigits("123454321", 7);
    System.out.println(s);
  }

}
