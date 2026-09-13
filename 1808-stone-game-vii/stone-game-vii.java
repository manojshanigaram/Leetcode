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
    int getSum(int l, int r) {
        return preSum[r + 1] - preSum[l];
    }
    int dp(int l, int r, int isAlice) {
        if (l == r) return 0;
        if (memo[l][r][isAlice] != null) return memo[l][r][isAlice];
        if (isAlice == 1) {
            int a = dp(l + 1, r, 1 - isAlice) + getSum(l + 1, r);
            int b = dp(l, r - 1, 1 - isAlice) + getSum(l, r - 1);
            return memo[l][r][isAlice] = Math.max(a, b);
        } else {
            int a = dp(l + 1, r, 1 - isAlice) - getSum(l + 1, r);
            int b = dp(l, r - 1, 1 - isAlice) - getSum(l, r - 1);
            return memo[l][r][isAlice] = Math.min(a, b);
        }
    }
}