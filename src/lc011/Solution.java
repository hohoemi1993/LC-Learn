package lc011;

/**
 * Created on 2019/2/14<br>
 *
 * @author dengxingda
 * @version 1.0
 */
public class Solution {
    /**
     * wrong
     */
    public int maxArea(int[] height) {
        if (height.length < 2) return 0;
        int maxPool = Math.min(height[0],height[1]);
        int one = 0;
        int two = 0;
        int three = 0;
        for (int i=0, j=1; j<height.length - 1;++j) {
            one =(j - i) * Math.min(height[i],height[j]);
            two = (j + 1 - i) * Math.min(height[i],height[j+1]);
            three = (j - i - 1) * Math.min(height[i + 1],height[j]);

            if (three > maxPool) ++i;

            maxPool = Math.max(Math.max(one,two),three);
        }

        return maxPool;
    }

    /**
     * brute force
     * T O(n^2)
     * S O(1)
     */
    public int maxArea001(int[] height) {
        int maxPool = 0;
        for (int i=0 ; i < height.length; ++i) {
            for (int j =i+1; j<height.length;++j ) {
                maxPool = Math.max(maxPool,(j - i) * Math.min(height[i],height[j]));
            }
        }
        return maxPool;
    }

    /**
     * two pointer approach
     * T O(n)
     * S O(1)
     */
    public int maxArea002(int[] height) {

        if (height.length < 2) return 0;

        int maxPool = 0;
        int i = 0;
        int j = height.length - 1;
        while (j > i) {
            maxPool = Math.max(maxPool,(j - i) * Math.min(height[i],height[j]) );
            if(height[i] < height[j]) ++i;
            else --j;
        }
        return maxPool;
    }
}
