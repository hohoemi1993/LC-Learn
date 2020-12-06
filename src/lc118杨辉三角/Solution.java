package lc118杨辉三角;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> ans = new ArrayList<>();
    if (numRows < 1) return ans;
    for (int i = 0; i < numRows; i++) {
      ArrayList<Integer> rowList = new ArrayList<>();
      if (ans.isEmpty()) {
        rowList.add(1);
        ans.add(rowList);
        continue;
      }
      List<Integer> prevList = ans.get(i-1);
      for (int j = 0; j <= i; j++) {
        if (j - 1 < 0) {
          rowList.add(1);
        } else if (j > i -1) {
          rowList.add(1);
        } else {
          rowList.add(prevList.get(j - 1) + prevList.get(j));
        }
      }
      ans.add(rowList);
    }
    return ans;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    List<List<Integer>> generate = solution.generate(5);
    for (List<Integer> integers : generate) {
      for (Integer integer : integers) {
        System.out.print(integer + " ");
      }
      System.out.println();
    }

  }
}
