class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums.length==1){
            return nums[0]>=target? 1 :0;
        }
        int i=0,j=i+1,min=nums.length+1,sum=0;
        for(j=0;j<nums.length;j++){
            sum+=nums[j];
            while(sum>=target){
                min=Math.min(min,j-i+1);
                sum-=nums[i++];
            }
        }
        return min==nums.length+1 ? 0: min;
    }
}