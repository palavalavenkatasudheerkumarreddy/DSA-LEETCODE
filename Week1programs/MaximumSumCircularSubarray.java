class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;

        int currMax = nums[0];
        int maxKadane = nums[0];

        int currMin = nums[0];
        int minKadane = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            totalSum += x;

            if (i > 0) {
                currMax = Math.max(x, currMax + x);
                maxKadane = Math.max(maxKadane, currMax);

                currMin = Math.min(x, currMin + x);
                minKadane = Math.min(minKadane, currMin);
            }
        }

        if (maxKadane < 0) {
            return maxKadane;
        }

        return Math.max(maxKadane, totalSum - minKadane);
    }
}