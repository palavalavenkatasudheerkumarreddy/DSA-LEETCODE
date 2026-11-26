import java.util.HashMap;
import java.util.Map;

class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long totalPairs = (long) n * (n - 1) / 2;
        long goodPairs = 0;

        Map<Integer, Long> freq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int key = nums[i] - i;
            long sameKeyCount = freq.getOrDefault(key, 0L);
            goodPairs += sameKeyCount;
            freq.put(key, sameKeyCount + 1);
        }

        return totalPairs - goodPairs;
    }
}