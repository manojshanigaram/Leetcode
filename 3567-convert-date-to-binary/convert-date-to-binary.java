class Solution {
    public String convertDateToBinary(String date) {
        int n=0;
        StringBuilder b=new StringBuilder();
        for(int i=0;i<date.length();i++){
            if(date.charAt(i)=='-'){
                b.append(bin(n));
                b.append('-');
                n=0;
            }else{
                n*=10;
                n+=date.charAt(i)-'0';
            }
        }
        b.append(bin(n));
        return b.toString();
    }
    private String bin(int n){
        if(n==0) return "0";
        StringBuilder s=new StringBuilder();
        while(n!=0){
            s.append(n%2);
            n=n/2;
        }
        return s.reverse().toString();
    }
}