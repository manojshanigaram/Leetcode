class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] temp = new int[deck.length+1];
        for(int x : deck){
            temp[x]++;
        }
        int gcd = -1;
        for(int val : temp){
            if(val>0){
                if(gcd==-1){
                    gcd = val;
                }
                else{
                    gcd = getgcd(gcd,val);
                }
            }
        }
        return gcd>1;
    }
    public static int getgcd(int a, int b){
        if(b==0){
            return a;
        }
        return getgcd(b,a%b);
    }
}