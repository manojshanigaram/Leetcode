class Solution {
    public int alternatingSum(int[] nums) {
        int sum=0,odd=0;
        if(nums.length==1) return nums[0];
        for(int i=0;i<nums.length;i++){
            if(i%2!=0) odd+=nums[i];
            else sum+=nums[i];
        }
        return sum-odd;
    }
}