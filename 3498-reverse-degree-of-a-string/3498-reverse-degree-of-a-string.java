class Solution {
    public int reverseDegree(String s) {
        int rev_Deg = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            int pos_in_str = i + 1;

            int rev_Alp_Pos = 26 - (ch - 'a');

            rev_Deg += (long) pos_in_str * rev_Alp_Pos;
        }
        return rev_Deg;
    }

}