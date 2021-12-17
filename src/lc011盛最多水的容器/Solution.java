package lc011盛最多水的容器;

public class Solution {


  public int maxArea(int[] height) {
    int i = 0;
    int j = height.length - 1;
    int area = 0;

    while (i < j) {
      area = Math.max(area,  (j - i) * Math.min(height[i], height[j]));
      if (height[i] < height[j]) {
        for (int k = 1; k < j - i; k++) {
          if (height[i+k] > height[i]) {
            i += k;
            area = Math.max(area,  (j - i) * Math.min(height[i], height[j]));
            break;
          }
          if (k == j - i) return area;
        }
      } else {
        for (int k = 1; k < j - i; k++) {
          if (height[j-k] > height[j]) {
            j -= k;
            area = Math.max(area,  (j - i) * Math.min(height[i], height[j]));
            break;
          }
          if (k == j - i) return area;
        }
      }
      if (height[i] < height[j]) {
        i++;
      } else {
        j--;
      }
    }

    return area;
  }
}
