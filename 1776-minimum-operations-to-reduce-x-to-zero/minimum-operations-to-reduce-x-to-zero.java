class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for (int num : nums) total += num;
        int t = total - x;
        if (t == 0) return nums.length;
        int left = 0, sum = 0, maxLen = -1;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > t && left <= right) {
                sum -= nums[left++];
            }
            if (sum == t) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen == -1 ? -1 : nums.length - maxLen;
    }
}