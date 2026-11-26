class Solution {
    public boolean canAliceWin(int n) {
        int minus = 10;

        int turn = 0;
        while(n>= minus){
            n = n- minus;
            minus--;
            turn++;
        }
        return turn % 2 ==1;
    }
}