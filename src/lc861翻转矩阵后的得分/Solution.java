package lc861翻转矩阵后的得分;

public class Solution {
    public int matrixScore(int[][] A) {
        if (null == A || A.length == 0) return 0;
        // 列数
        int m = A[0].length;
        // 行数
        int n = A.length;
        // 行变换
        for (int[] row : A) {
            if(row[0] == 0) {
                for (int i = 0; i < m; i++) {
                    row[i] = row[i] > 0 ? 0 : 1;
                }
            }
        }
        // 列变换
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int[] row : A) {
                if (row[i] < 1) {
                    count++;
                }
            }
            // 需要变换
            if (count > n /2) {
                for (int[] row : A) {
                    row[i] = row[i] > 0 ? 0 : 1;
                }
            }

        }
        // 二进制转换十进制
        int ans = 0;
        for (int[] row : A) {
            for (int i = 0; i < row.length; i++) {
                if (row[i] == 0) {
                    continue;
                }
                ans += Math.pow(row[i] * 2, m - i - 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] A =
                new int[][] {
                        {0,1},{1,1}
                };
//                new int[][] {
//                {0,0,1,1},{1,0,1,0},{1,1,0,0}
//        };
        int i = solution.matrixScore(A);
        System.out.println(i);
    }
}
