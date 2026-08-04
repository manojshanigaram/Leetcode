class Solution {
    public int digitFrequencyScore(int n) {
        int[] h=new int[10];
        int x=n,sum=0;
        while(x>0){
            int y=x%10;
            h[y]++;
            x=x/10;
        }
        int i=0;
        while(i<10){
            if(h[i]!=0){
                sum+=i*h[i];
            }
            i++;
        }
        return sum;
    }
}