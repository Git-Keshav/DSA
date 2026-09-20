class Solution {
    public int firstUniqChar(String s) {
        int firstnR = -1;

        int[] charCnt = new int[26];

        for(int i = 0; i< s.length(); i++){
            charCnt[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i< s.length(); i++){
            if(charCnt[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;          
    }
}