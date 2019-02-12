package lc004;

/**
 * Created on 2019/2/12<br>
 *
 * @author dengxingda
 * @version 1.0
 */
public class Solution {
    /**
     * logic is simple
     * T: O (n+m)
     * S: O(n+m)
     */
    public double findMedianSortedArrays001(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] merge = new int[len];
        int p = 0;
        int q = 0;

        for(int i = 0; i<len; ++i) {
            if ( p >= nums1.length){
                merge[i++] = nums2[q++];
                continue;
            }
            if ( q >= nums2.length){
                merge[i++] = nums1[p++];
                continue;
            }

            if (nums1[p] < nums2[q])
                merge[i++] = nums1[p++];
            else
                merge[i++] = nums2[q++];
        }

        if (len % 2 == 1)
            return merge[len/2];
        else
            return (merge[len/2] + merge[len/2 -1]) / 2.0;
    }
}
