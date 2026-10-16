class Solution {
    static final int MOD = 1_000_000_007;

    class SegmentTree {
        long[] sum;
        long[] sumSquares;
        long[] lazy;
        int n;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[4 * n];
            sumSquares = new long[4 * n];
            lazy = new long[4 * n];
        }

        void update(int node, int start, int end,
                    int left, int right, long val) {

            if (right < start || end < left) {
                return;
            }

            if (left <= start && end <= right) {
                apply(node, start, end, val);
                return;
            }

            push(node, start, end);

            int mid = (start + end) / 2;

            update(node * 2, start, mid, left, right, val);
            update(node * 2 + 1, mid + 1, end,
                   left, right, val);

            sum[node] =
                (sum[node * 2] + sum[node * 2 + 1]) % MOD;

            sumSquares[node] =
                (sumSquares[node * 2]
                + sumSquares[node * 2 + 1]) % MOD;
        }

        void apply(int node, int start, int end, long val) {
            long len = end - start + 1L;

            long oldSum = sum[node];

            sumSquares[node] =
                (sumSquares[node]
                + 2L * val % MOD * oldSum % MOD
                + len % MOD * val % MOD * val % MOD)
                % MOD;

            sum[node] =
                (sum[node] + len % MOD * val % MOD) % MOD;

            lazy[node] = (lazy[node] + val) % MOD;
        }

        void push(int node, int start, int end) {
            if (lazy[node] == 0 || start == end) {
                return;
            }

            int mid = (start + end) / 2;

            apply(node * 2, start, mid, lazy[node]);
            apply(node * 2 + 1, mid + 1, end, lazy[node]);

            lazy[node] = 0;
        }

        void update(int left, int right, long val) {
            if (left <= right) {
                update(1, 0, n - 1, left, right, val);
            }
        }

        long getSumSquares() {
            return sumSquares[1];
        }
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;

        SegmentTree seg = new SegmentTree(n);

        HashMap<Integer, Integer> lastSeen = new HashMap<>();

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int last = lastSeen.getOrDefault(nums[i], -1);

            seg.update(last + 1, i, 1);

            lastSeen.put(nums[i], i);

            ans = (ans + seg.getSumSquares()) % MOD;
        }

        return (int) ans;
    
    }
}