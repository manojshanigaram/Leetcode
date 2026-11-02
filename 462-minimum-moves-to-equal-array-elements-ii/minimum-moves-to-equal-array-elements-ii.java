class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int med = nums[nums.length / 2];
        int m = 0;
        for (int num : nums) {
            m += Math.abs(num - med);
        }
        return m;
    }
}