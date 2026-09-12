class Solution {

    static class Interval {
        int l, r, w, idx;

        Interval(int l, int r, int w, int idx) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.idx = idx;
        }
    }

    static class Result {
        long score;
        List<Integer> indices;

        Result(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    Interval[] arr;
    Result[][] dp;

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();
        arr = new Interval[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.l != b.l) return Integer.compare(a.l, b.l);
            if (a.r != b.r) return Integer.compare(a.r, b.r);
            return Integer.compare(a.idx, b.idx);
        });

        dp = new Result[n][5];

        Result ans = solve(0, 4);

        int[] res = new int[ans.indices.size()];

        for (int i = 0; i < ans.indices.size(); i++) {
            res[i] = ans.indices.get(i);
        }

        return res;
    }

    Result solve(int i, int k) {

        if (i >= arr.length || k == 0) {
            return new Result(0, new ArrayList<>());
        }

        if (dp[i][k] != null) {
            return dp[i][k];
        }

        Result skip = solve(i + 1, k);

        int next = findNext(i, arr[i].r);

        Result nextResult = solve(next, k - 1);

        List<Integer> takeIndices = new ArrayList<>();
        takeIndices.add(arr[i].idx);
        takeIndices.addAll(nextResult.indices);

        Collections.sort(takeIndices);

        Result take = new Result(
            arr[i].w + nextResult.score,
            takeIndices
        );

        if (take.score > skip.score) {
            return dp[i][k] = take;
        }

        if (take.score < skip.score) {
            return dp[i][k] = skip;
        }

        if (compare(take.indices, skip.indices) < 0) {
            return dp[i][k] = take;
        }

        return dp[i][k] = skip;
    }

    int findNext(int i, int right) {

        int lo = i + 1;
        int hi = arr.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid].l > right) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    int compare(List<Integer> a, List<Integer> b) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }

        return Integer.compare(a.size(), b.size());
    }
}