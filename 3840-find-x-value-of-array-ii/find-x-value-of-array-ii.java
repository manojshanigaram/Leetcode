
class Solution {
    int n, k;
    Node[] tree;
    class Node {
        int prod;
        int[] cnt;
        Node() {
            prod = 1;
            cnt = new int[k];
        }
    }
    Node merge(Node a, Node b) {
        Node c = new Node();
        c.prod = (a.prod * b.prod) % k;
        for (int i = 0; i < k; i++) {
            c.cnt[i] += a.cnt[i];
            c.cnt[(a.prod * i) % k] += b.cnt[i];
        }
        return c;
    }
    void build(int p, int l, int r, int[] nums) {
        if (l == r) {
            tree[p].prod = nums[l] % k;
            tree[p].cnt[tree[p].prod] = 1;
            return;
        }
        int m = (l + r) / 2;
        build(p * 2, l, m, nums);
        build(p * 2 + 1, m + 1, r, nums);
        tree[p] = merge(tree[p * 2], tree[p * 2 + 1]);
    }

    void update(int p, int l, int r, int idx, int val) {
        if (l == r) {
            tree[p] = new Node();
            val %= k;
            tree[p].prod = val;
            tree[p].cnt[val] = 1;
            return;
        }
        int m = (l + r) / 2;
        if (idx <= m)
            update(p * 2, l, m, idx, val);
        else
            update(p * 2 + 1, m + 1, r, idx, val);

        tree[p] = merge(tree[p * 2], tree[p * 2 + 1]);
    }
    Node query(int p, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr)
            return tree[p];
        int m = (l + r) / 2;
        if (qr <= m)
            return query(p * 2, l, m, ql, qr);
        if (ql > m)
            return query(p * 2 + 1, m + 1, r, ql, qr);
        return merge(
            query(p * 2, l, m, ql, qr),
            query(p * 2 + 1, m + 1, r, ql, qr)
        );
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;
        tree = new Node[4 * n];
        for (int i = 0; i < tree.length; i++)
            tree[i] = new Node();
        build(1, 0, n - 1, nums);
        int[] ans = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];
            update(1, 0, n - 1, index, value);
            Node res = query(1, 0, n - 1, start, n - 1);
            ans[q] = res.cnt[x];
        }
        return ans;
    }
}