class Solution {
    public String freqAlphabets(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int num;

            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                num = Integer.parseInt(s.substring(i, i + 2));
                i += 2;
            } else {
                num = s.charAt(i) - '0';
            }

            result.append((char) ('a' + num - 1));
        }

        return result.toString();
    }
}