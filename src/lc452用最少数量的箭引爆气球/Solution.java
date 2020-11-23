package lc452用最少数量的箭引爆气球;

import java.util.Arrays;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        int ans = 0;
        // 对points的右边界做升序排列
        Arrays.sort(points, (o1, o2)-> o1[1]>o2[1] ? 1 : -1);
        // 0 表示还没爆
        int[] burst = new int[points.length];

        for (int i = 0; i < burst.length; i++) {
            if (burst[i] != 0) {
                continue;
            }
            for (int j = i; j < points.length; j++) {
                if (points[j][0] <= points[i][1]) {
                    burst[j] = -1;
                } else {
                    break;
                }
            }
            ans++;
        }
        return ans;

    }
}
