class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n=nums.length,j=0;
        int[] arr=new int[n];
        for(int num : nums){
            if(num < pivot) arr[j++]=num;
        }
        for(int num : nums){
            if(num == pivot) arr[j++]=num;
        }
        for(int num : nums){
            if(num > pivot) arr[j++]=num;
        }
        return arr;
    }
}