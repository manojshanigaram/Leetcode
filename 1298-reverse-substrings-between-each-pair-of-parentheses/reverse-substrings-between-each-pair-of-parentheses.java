class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int[] pair = new int[s.length()];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') st.push(i);
            else if (s.charAt(i) == ')') {
                int j = st.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }
        int i = 0, d = 1;
        while (i < s.length()) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = pair[i];
                d = -d;
            } else {
                sb.append(s.charAt(i));
            }
            i += d;
        }
        return sb.toString();
    }
}