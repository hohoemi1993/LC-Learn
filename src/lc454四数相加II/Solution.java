package lc454四数相加II;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // <(A + B), count>
        HashMap<Long, Integer> map = new HashMap<>(1 << 10);
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                long ab = A[i] + B[j];
                if (map.containsKey(ab)) {
                    Integer count = map.get(ab);
                    map.put(ab, ++count);
                } else {
                    map.put(ab, 1);
                }
            }
        }

        for (int k = 0; k < C.length; k++) {
            for (int l = 0; l < D.length; l++) {
                long cd = C[k] + D[l];
                if (map.containsKey(-cd)) {
                    ans += map.get(-cd);
                }
            }
        }
        return ans;
    }
}
