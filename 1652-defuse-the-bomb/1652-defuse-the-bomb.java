class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        if (k == 0)
            return result;

        int windowEnd = 0, windowStart = 0, windowSum = 0;

        if (k > 0) {
            for (int i = 1; i <= k; i++) {
                windowSum += code[i % n];
            }

            result[0] = windowSum;

            for (windowEnd = 1; windowEnd < n; windowEnd++) {
                windowSum -= code[windowEnd % n];
                windowSum += code[(windowEnd + k) % n];

                result[windowEnd] = windowSum;
            }
        } else {
            k = -k;
            for (int i = 1; i <= k; i++) {
                windowSum += code[(n - i) % n];
            }
            result[0] = windowSum;

            for (windowEnd = 1; windowEnd < n; windowEnd++) {
                windowSum -= code[(windowEnd - k - 1 + n) % n];
                windowSum += code[(windowEnd - 1 + n) % n];
                
                result[windowEnd] = windowSum;
            }
        }
        return result;
    }
}