import java.util.*;

class Solution {

    private static class Node {
        int ones;
        int maxZ;
        int max_Z_sum;
        int min_O;
        
        boolean exact;
        int[] pref;
        int pref_type;
        int[] suff;
        int suff_type;
        
        Node() {
            max_Z_sum = -1;
            min_O = 1000000000;
        }
    }
    
    private Node[] tree;
    
    private int[] mergeArrays(int[] A, int typeA, int[] B, int typeB) {
        int lastTypeA = (typeA + A.length - 1) % 2;
        if (lastTypeA == typeB) {
            int[] M = new int[A.length + B.length - 1];
            for (int i = 0; i < A.length - 1; i++) M[i] = A[i];
            M[A.length - 1] = A[A.length - 1] + B[0];
            for (int i = 1; i < B.length; i++) M[A.length - 1 + i] = B[i];
            return M;
        } else {
            int[] M = new int[A.length + B.length];
            for (int i = 0; i < A.length; i++) M[i] = A[i];
            for (int i = 0; i < B.length; i++) M[A.length + i] = B[i];
            return M;
        }
    }
    
    private void evaluate(int[] M, int typeM, Node res) {
        for (int i = 0; i < M.length; i++) {
            int type = (typeM + i) % 2;
            if (type == 0) {
                res.maxZ = Math.max(res.maxZ, M[i]);
            } else {
                if (i > 0 && i < M.length - 1) {
                    res.max_Z_sum = Math.max(res.max_Z_sum, M[i-1] + M[i+1]);
                    res.min_O = Math.min(res.min_O, M[i]);
                }
            }
        }
    }
    
    private Node mergeNodes(Node L, Node R) {
        if (L == null) return R;
        if (R == null) return L;
        
        Node res = new Node();
        res.ones = L.ones + R.ones;
        res.maxZ = Math.max(L.maxZ, R.maxZ);
        res.max_Z_sum = Math.max(L.max_Z_sum, R.max_Z_sum);
        res.min_O = Math.min(L.min_O, R.min_O);
        
        if (L.exact && R.exact) {
            int[] M = mergeArrays(L.pref, L.pref_type, R.pref, R.pref_type);
            evaluate(M, L.pref_type, res);
            if (M.length <= 6) {
                res.exact = true;
                res.pref = M; res.pref_type = L.pref_type;
            } else {
                res.exact = false;
                res.pref = Arrays.copyOfRange(M, 0, 3);
                res.pref_type = L.pref_type;
                res.suff = Arrays.copyOfRange(M, M.length - 3, M.length);
                res.suff_type = (L.pref_type + M.length - 3) % 2;
            }
        } else if (!L.exact && R.exact) {
            int[] M = mergeArrays(L.suff, L.suff_type, R.pref, R.pref_type);
            evaluate(M, L.suff_type, res);
            res.exact = false;
            res.pref = L.pref; res.pref_type = L.pref_type;
            if (M.length <= 3) {
                res.suff = M; res.suff_type = L.suff_type;
            } else {
                res.suff = Arrays.copyOfRange(M, M.length - 3, M.length);
                res.suff_type = (L.suff_type + M.length - 3) % 2;
            }
        } else if (L.exact && !R.exact) {
            int[] M = mergeArrays(L.pref, L.pref_type, R.pref, R.pref_type);
            evaluate(M, L.pref_type, res);
            res.exact = false;
            res.suff = R.suff; res.suff_type = R.suff_type;
            if (M.length <= 3) {
                res.pref = M; res.pref_type = L.pref_type;
            } else {
                res.pref = Arrays.copyOfRange(M, 0, 3);
                res.pref_type = L.pref_type;
            }
        } else {
            int[] M = mergeArrays(L.suff, L.suff_type, R.pref, R.pref_type);
            evaluate(M, L.suff_type, res);
            res.exact = false;
            res.pref = L.pref; res.pref_type = L.pref_type;
            res.suff = R.suff; res.suff_type = R.suff_type;
        }
        return res;
    }
    
    private void build(int node, int start, int end, char[] s) {
        if (start == end) {
            tree[node] = new Node();
            tree[node].exact = true;
            tree[node].pref = new int[]{1};
            if (s[start] == '1') {
                tree[node].ones = 1;
                tree[node].maxZ = 0;
                tree[node].pref_type = 1;
            } else {
                tree[node].ones = 0;
                tree[node].maxZ = 1;
                tree[node].pref_type = 0;
            }
            return;
        }
        int mid = (start + end) / 2;
        build(2 * node, start, mid, s);
        build(2 * node + 1, mid + 1, end, s);
        tree[node] = mergeNodes(tree[2 * node], tree[2 * node + 1]);
    }
    
    private Node queryTree(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return null;
        if (l <= start && end <= r) return tree[node];
        int mid = (start + end) / 2;
        Node left = queryTree(2 * node, start, mid, l, r);
        Node right = queryTree(2 * node + 1, mid + 1, end, l, r);
        return mergeNodes(left, right);
    }
    
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        char[] charArr = s.toCharArray();
        
        int totalOnesInS = 0;
        for (char c : charArr) {
            if (c == '1') totalOnesInS++;
        }
        
        tree = new Node[4 * n + 1];
        build(1, 0, n - 1, charArr);
        
        List<Integer> answer = new ArrayList<>(queries.length);
        for (int[] q : queries) {
            Node res = queryTree(1, 0, n - 1, q[0], q[1]);
            
            if (res.max_Z_sum == -1) {
                
                answer.add(totalOnesInS);
            } else {
                int maxGain = Math.max(res.max_Z_sum, res.maxZ - res.min_O);
                answer.add(totalOnesInS + maxGain);
            }
        }
        
        return answer;
    }
}