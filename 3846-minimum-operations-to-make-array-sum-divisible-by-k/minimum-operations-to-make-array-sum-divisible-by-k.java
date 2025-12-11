class Solution {
    public int minOperations(int[] nums, int k) {
        
        return min(nums,k);
    }
    private int min(int[] arr,int n){
        int s=0;
        for(int i=0;i<arr.length;i++){
            s+=arr[i];
        }
        return s%n;
    }
}