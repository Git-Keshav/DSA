class Solution {
    class Node {
        int size;
        int maxL;
        int prefLen;
        int suffLen;
        char prefChar;
        char suffChar;
        
        public Node() {}
    }
    
    Node[] tree;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        tree = new Node[4 * n];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new Node();
        }
        
        build(0, 0, n - 1, s);
        
        int k = queryIndices.length;
        int[] ans = new int[k];
        
        for (int i = 0; i < k; i++) {
            update(0, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
            ans[i] = tree[0].maxL;
        }
        
        return ans;
    }
    
    private void merge(Node parent, Node left, Node right) {
        parent.size = left.size + right.size;
        
        parent.prefChar = left.prefChar;
        parent.prefLen = left.prefLen;
        if (left.prefLen == left.size && left.prefChar == right.prefChar) {
            parent.prefLen += right.prefLen;
        }
        
        parent.suffChar = right.suffChar;
        parent.suffLen = right.suffLen;
        if (right.suffLen == right.size && right.suffChar == left.suffChar) {
            parent.suffLen += left.suffLen;
        }
        
        parent.maxL = Math.max(left.maxL, right.maxL);
        if (left.suffChar == right.prefChar) {
            parent.maxL = Math.max(parent.maxL, left.suffLen + right.prefLen);
        }
    }
    
    private void build(int node, int start, int end, String s) {
        if (start == end) {
            tree[node].size = 1;
            tree[node].maxL = 1;
            tree[node].prefLen = 1;
            tree[node].suffLen = 1;
            tree[node].prefChar = s.charAt(start);
            tree[node].suffChar = s.charAt(start);
            return;
        }
        
        int mid = start + (end - start) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;
        
        build(leftChild, start, mid, s);
        build(rightChild, mid + 1, end, s);
        
        merge(tree[node], tree[leftChild], tree[rightChild]);
    }
    
    private void update(int node, int start, int end, int idx, char c) {
        if (start == end) {
            tree[node].prefChar = c;
            tree[node].suffChar = c;
            return;
        }
        
        int mid = start + (end - start) / 2;
        int leftChild = 2 * node + 1;
        int rightChild = 2 * node + 2;
        
        if (idx <= mid) {
            update(leftChild, start, mid, idx, c);
        } else {
            update(rightChild, mid + 1, end, idx, c);
        }
        
        merge(tree[node], tree[leftChild], tree[rightChild]);
    }
}