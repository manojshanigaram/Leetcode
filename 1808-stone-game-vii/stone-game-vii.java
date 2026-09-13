class Solution {
    int[] preSum;
    Integer[][][] memo;
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        preSum = new int[n + 1];
        memo = new Integer[n][n][2];
        for (int i = 0; i < n; i++)
            preSum[i + 1] = preSum[i] + stones[i];
        return dp(0, n - 1, 1);
    }
    int getSum(int left, int r) {
        return preSum[r + 1] - preSum[left];
    }
    int dp(int left, int r, int isAlice) {
        if (left == r) return 0;
        if (memo[left][r][isAlice] != null) return memo[left][r][isAlice];
        if (isAlice == 1) {
            int a = dp(left + 1, r, 1 - isAlice) + getSum(left + 1, r);
            int b = dp(left, r - 1, 1 - isAlice) + getSum(left, r - 1);
            return memo[left][r][isAlice] = Math.max(a, b);
        } else {
            int a = dp(left + 1, r, 1 - isAlice) - getSum(left + 1, r); // Take leftmost
            int b = dp(left, r - 1, 1 - isAlice) - getSum(left, r - 1); // Take rmost
            return memo[left][r][isAlice] = Math.min(a, b);
        }
    }
}