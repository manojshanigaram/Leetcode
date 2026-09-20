class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int i = 0, j = nums.size() - 1, ans = 0;
        while (i < j) {
            if (nums.get(i) + nums.get(j) < target) {
                ans += j - i;
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}