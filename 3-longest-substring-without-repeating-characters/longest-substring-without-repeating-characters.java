class Solution {
    public int lengthOfLongestSubstring(String s) {
        return Max(s);
    }
    private int Max(String s){
        int x=0;
        for(int i=0;i<s.length();i++){
            Set<Character> charSet=new HashSet<>();
            for(int j=i;j<s.length();j++){
                if(charSet.contains(s.charAt(j))){
                    break;
                }
                charSet.add(s.charAt(j));
            }
            x=Math.max(x,charSet.size());
        }
        return x;
    }
}
