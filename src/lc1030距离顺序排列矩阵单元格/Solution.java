package lc1030距离顺序排列矩阵单元格;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        Map<Integer, List<int[]>> map = new TreeMap<>();
        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                int dis = Math.abs(i-r0) + Math.abs(j-c0);
                if (map.containsKey(dis)) {
                    map.get(dis).add(new int[]{i,j});
                } else {
                    List<int[]> list = new ArrayList<>();
                    list.add(new int[]{i,j});
                    map.put(dis, list);
                }
            }
        }
        int[][] ans = new int[R*C][];
        int index = 0;
        for (List<int[]> value : map.values()) {
            for (int[] point : value) {
                ans[index++ ] = point;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = solution.allCellsDistOrder(2, 3, 1, 2);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }
    }
}
