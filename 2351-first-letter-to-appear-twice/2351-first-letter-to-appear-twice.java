class Solution {
    public char repeatedCharacter(String s) {
        boolean[] charSeen = new boolean[26];

        for(int i = 0; i< s.length(); i++){
            char a = s.charAt(i);
            if(charSeen[a - 'a']){
                return a;
            }
            charSeen[a - 'a'] = true;
        }
    return ' ';
    }
}