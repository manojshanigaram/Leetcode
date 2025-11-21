class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        
        for (int i = 0; i < 26; i++) first[i] = -1;

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            if (first[idx] == -1) first[idx] = i;
            last[idx] = i;
        }

        int total = 0;

        for (int c = 0; c < 26; c++) {
            if (first[c] != -1 && first[c] < last[c]) {
                boolean[] seen = new boolean[26];

                for (int i = first[c] + 1; i < last[c]; i++) {
                    seen[s.charAt(i) - 'a'] = true;
                }
                int count = 0;
                for (boolean b : seen) if (b) count++;
                
                total += count;
            }
        }

        return total;
    }
}
