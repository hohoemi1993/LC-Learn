package lc48旋转图像;

public class Solution {

  public void rotate(int[][] matrix) {
    if (null == matrix || matrix.length < 2) {
      return;
    }
    int n = matrix.length;
    int layer = 0;
    int temp;
    while ((n + 1) / 2 - layer > 0) {
      for (int i = layer; i < n - 1 - layer; i++) {
        if (layer == n - 1 - layer) {
          return;
        }
        temp = matrix[layer][i];
        matrix[layer][i] = matrix[n - 1 - i][layer];
        matrix[n - 1 - i][layer] = matrix[n - 1 - layer][n - 1 - i];
        matrix[n - 1 - layer][n - 1 - i] = matrix[i][n - 1 - layer];
        matrix[i][n - 1 - layer] = temp;
      }
      layer++;
    }
  }
}
