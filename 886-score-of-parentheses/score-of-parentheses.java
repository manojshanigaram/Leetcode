class Solution {
    public int scoreOfParentheses(String s) {
        int c=0,d=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                d++;
            } else {
                d--;
                if (s.charAt(i - 1) == '(')
                    c += 1 << d;
            }
        }
        return c;
    }
}