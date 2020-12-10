package lc62不同路径;

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        int a ;
        int b ;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0 && j==0) continue;
                if (i-1<0) {
                  a = 0;
                } else {
                    a = dp[i-1][j];
                }
                if (j-1<0) {
                    b = 0;
                } else {
                    b = dp[i][j-1];
                }
                dp[i][j] = a + b;
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.uniquePaths(3, 7);
        System.out.println(i);
    }
}
