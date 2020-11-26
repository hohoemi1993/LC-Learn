package lc164最大间距;

public class Solution {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        // 抽屉定理
        int gap = Math.max((max - min) / (nums.length - 1), 1);
        // [min, a), [a, b] ··· [n, max]
        Bucket[] buckets = new Bucket[(max - min) / gap + 1];
        for (int i = 0; i < nums.length; i++) {
            int bucketIndex = (nums[i] - min) / gap;
            if (buckets[bucketIndex] == null) {
                buckets[bucketIndex] = new Bucket();
            }
            buckets[bucketIndex].setMax(nums[i]);
            buckets[bucketIndex].setMin(nums[i]);
        }
        int maxGap = 0;
        int preMax = -1;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null && preMax != -1)
                maxGap = Math.max((buckets[i].min - preMax), maxGap);
            if (buckets[i] != null)
                preMax = buckets[i].max;
        }
        return maxGap;

    }

    private static class Bucket {
        int max = -1;
        int min = Integer.MAX_VALUE;

        void setMax(int num) {
            max = Math.max(max, num);
        }

        void setMin(int num){
            min = Math.min(min, num);
        }
    }
}
