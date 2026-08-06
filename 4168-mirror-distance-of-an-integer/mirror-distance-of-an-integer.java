class Solution {
    public int mirrorDistance(int n) {
        return Math.abs(n-reverse(n));
    }
    private int reverse(int n){
        int x=0;
        while(n!=0){
            int r=n%10;
            x=x*10+r;
            n/=10;
        }
        return x;
    }
}