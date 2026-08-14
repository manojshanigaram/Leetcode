class Solution {
    public List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, new StringBuilder(), res);
        return res;
    }

    private void dfs(int n, StringBuilder curr, List<String> res) {
        if (curr.length() == n) {
            res.add(curr.toString());
            return;
        }
        curr.append('1');
        dfs(n, curr, res);
        curr.deleteCharAt(curr.length() - 1);
        if (curr.length() == 0 || curr.charAt(curr.length() - 1) == '1') {
            curr.append('0');
            dfs(n, curr, res);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
