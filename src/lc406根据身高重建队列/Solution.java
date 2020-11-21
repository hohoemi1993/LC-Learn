package lc406根据身高重建队列;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int[][] reconstructQueue(int[][] people) {
        if (null == people || people.length == 0)
            return people;
        // 对people按照(h, k) h为第一优先, k为第二优先排序
        // O(n*logn)
        Arrays.sort(people, (Comparator.comparingInt(o -> (o[0] * 10 + o[1]))));

        // 认为身高一定大于0 结果有0身高的憨憨
        // 0值表示位置为空，大于0表示满
        int[][] ans = new int[people.length][2];
        Arrays.fill(ans, new int[]{-1, 0});
        for (int[] p : people) {
            int k = p[1];
            for (int i = 0; i < ans.length; i++) {
                if (ans[i][0] != -1 && ans[i][0] < p[0]) {
                    continue;
                }
                if (k == 0) {
                    ans[i] = p;
                    break;
                }
                if (ans[i][0] == -1 || ans[i][0] >= p[0]) {
                    k--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[][] people = new int[][] {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] people = new int[][] {{2,0},{1,1}};
        int[][] ans = solution.reconstructQueue(people);
        for (int[] an : ans) {
            for (int i : an) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
