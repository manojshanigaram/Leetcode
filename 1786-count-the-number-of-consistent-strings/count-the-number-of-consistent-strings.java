class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int m = 0;

        for (char c : allowed.toCharArray()) {
            m |= (1 << (c - 'a'));
        }

        int cnt = 0;

        for (String word : words) {
            boolean con = true;

            for (char c : word.toCharArray()) {
                if ((m & (1 << (c - 'a'))) == 0) {
                    con = false;
                    break;
                }
            }

            if (con) {
                cnt++;
            }
        }

        return cnt;
    }
}