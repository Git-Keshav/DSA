class Solution {
    public int maxActiveSectionsAfterTrade(String s) {

        String t = "1" + s + "1";
        int n = t.length();

        int iniOne = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                iniOne++;
            }
        }

        java.util.List<Integer> ones = new java.util.ArrayList<>();
        java.util.List<Integer> zeros = new java.util.ArrayList<>();

        int i = 0;
        while (i < n) {
            char c = t.charAt(i);
            int len = 0;
            while (i < n && t.charAt(i) == c) {
                len++;
                i++;
            }
            if (c == '1') {
                ones.add(len);
            } else {
                zeros.add(len);
            }
        }

        int mxG = 0;
        
        for (int k = 1; k < ones.size() - 1; k++) {
            int leftzero = zeros.get(k - 1);
            int rightzero = zeros.get(k);

            mxG = Math.max(mxG, leftzero + rightzero);
        }

        return iniOne + mxG;
    }
}