class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];
        for (int i = 2; i <= right; i++) {
            isPrime[i] = true;
        }

        for (long i = 2; i * i <= right; i++) {
            if (isPrime[(int) i]) {
                for (long j = i * i; j <= right; j += i) {
                    isPrime[(int) j] = false;
                }
            }
        }

        int prevPrime = -1;
        int minGap = Integer.MAX_VALUE;
        int[] ans = new int[]{-1, -1};

        for (int num = left; num <= right; num++) {
            if (isPrime[num]) {
                if (prevPrime != -1) {
                    int gap = num - prevPrime;
                    if (gap < minGap) {
                        minGap = gap;
                        ans[0] = prevPrime;
                        ans[1] = num;
                        if (minGap <= 2) {
                            return ans;
                        }
                    }
                }
                prevPrime = num;
            }
        }

        return ans;
    }
}