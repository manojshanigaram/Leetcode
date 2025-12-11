class Solution {
    public int scoreOfString(String s) {
        return score(s);
    }
    private int score(String str){
        int s=0;
        for(int i=0;i<str.length()-1;i++){
            int x=str.charAt(i)-'0';
            int y=str.charAt(i+1)-'0';
            if(x>y){
                s+=(x-y);
            }else{
                s+=(y-x);
            }
        }
        return s;
    }
}