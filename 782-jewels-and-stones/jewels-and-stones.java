class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int c = 0;
        for (char j : jewels.toCharArray()) {
            for (char s : stones.toCharArray()) {
                if (j == s) {
                    c++;
                }
            }
        }
        return c;
    }
}