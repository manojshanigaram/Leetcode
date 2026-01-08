class Solution {
    static class N {
        int[] a; long[] p;
        N(int[] a) {
            this.a = a;
            p = new long[a.length + 1];
            for (int i = 0; i < a.length; i++)
                p[i + 1] = p[i] + a[i];
        }
        int c(int x) {
            int l = 0, r = a.length;
            while (l < r) {
                int m = (l + r) / 2;
                if (a[m] <= x) l = m + 1;
                else r = m;
            }
            return l;
        }
        long s(int x) { return p[c(x)]; }
    }

    N[] t; int n;

    public long[] minOperations(int[] A, int k, int[][] Q) {
        n = A.length;
        int[] m = new int[n], b = new int[n];
        for (int i = 0; i < n; i++) {
            m[i] = A[i] % k;
            b[i] = A[i] / k;
        }

        t = new N[4 * n];
        build(1, 0, n - 1, b);

        int globalMin = Integer.MAX_VALUE, globalMax = Integer.MIN_VALUE;
        for (int x : b) {
            if (x < globalMin) globalMin = x;
            if (x > globalMax) globalMax = x;
        }

        int[] bad = new int[n];
        for (int i = 1; i < n; i++)
            bad[i] = bad[i - 1] + (m[i] != m[i - 1] ? 1 : 0);

        long[] ans = new long[Q.length];

        for (int qi = 0; qi < Q.length; qi++) {
            int l = Q[qi][0], r = Q[qi][1];

            if (bad[r] > bad[l]) {
                ans[qi] = -1;
                continue;
            }

            int len = r - l + 1;
            int need = (len + 1) / 2;

            // find median value using binary search on value
            int lo = globalMin, hi = globalMax;
            while (lo < hi) {
                int midv = lo + (hi - lo) / 2;
                int cnt = count(1, 0, n - 1, l, r, midv);
                if (cnt >= need) hi = midv;
                else lo = midv + 1;
            }
            int med = lo;

            int kpos = (len + 1) / 2;

            long sumLess = sum(1, 0, n - 1, l, r, med - 1);
            long cntLess = count(1, 0, n - 1, l, r, med - 1);
            long sumTotal = sum(1, 0, n - 1, l, r, Integer.MAX_VALUE);

            long leftSum  = sumLess + (kpos - cntLess) * med;
            long leftCost = (long) kpos * med - leftSum;

            long rightSum  = sumTotal - leftSum;
            long rightCost = rightSum - (long) (len - kpos) * med;

            ans[qi] = leftCost + rightCost;
        }

        return ans;
    }

    void build(int i, int l, int r, int[] b) {
        if (l == r) { t[i] = new N(new int[]{b[l]}); return; }
        int m = (l + r) / 2;
        build(i * 2, l, m, b);
        build(i * 2 + 1, m + 1, r, b);
        int[] x = t[i * 2].a, y = t[i * 2 + 1].a;
        int[] z = new int[x.length + y.length];
        int p = 0, q = 0, d = 0;
        while (d < z.length) {
            z[d++] = (q == y.length || (p < x.length && x[p] <= y[q])) ? x[p++] : y[q++];
        }
        t[i] = new N(z);
    }

    int count(int i, int l, int r, int ql, int qr, int x) {
        if (l > qr || r < ql) return 0;
        if (ql <= l && r <= qr) return t[i].c(x);
        int m = (l + r) / 2;
        return count(i * 2, l, m, ql, qr, x) +
               count(i * 2 + 1, m + 1, r, ql, qr, x);
    }

    long sum(int i, int l, int r, int ql, int qr, int x) {
        if (l > qr || r < ql) return 0;
        if (ql <= l && r <= qr) return t[i].s(x);
        int m = (l + r) / 2;
        return sum(i * 2, l, m, ql, qr, x) +
               sum(i * 2 + 1, m + 1, r, ql, qr, x);
    }
}