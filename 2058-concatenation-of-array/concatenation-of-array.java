class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] arr=new int[nums.length*2];
        int x=0;
        for(int i=0;i<nums.length;i++){
            arr[x++]=nums[i];
        }
        for(int i=0;i<nums.length;i++){
            arr[x++]=nums[i];
        }
        return arr;
    }
}