class Solution {
    public int reverseDegree(String s) {
        int[] h=new int[26];
        for(int i=0;i<26;i++){
            h[i]=26-i;
        }
        int sum=0;
        for(int i=0;i<s.length();i++){
            sum+=((i+1)*h[s.charAt(i)-'a']);
        }
        return sum;
    }
}