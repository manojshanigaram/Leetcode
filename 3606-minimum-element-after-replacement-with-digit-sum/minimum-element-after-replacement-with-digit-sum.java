class Solution {
    public int minElement(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(min>dsum(nums[i])) min=dsum(nums[i]);
        }
        return min;
    }
        private int dsum(int n){
        int sum=0;
        while(n!=0){
            int r=n%10;
            sum+=r;
            n=n/10;
        }
        return sum;
    }
}