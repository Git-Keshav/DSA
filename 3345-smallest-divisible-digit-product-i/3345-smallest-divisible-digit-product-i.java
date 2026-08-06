class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            int digPrd = 1;
            int tmp = n;

            while (tmp > 0) {
                int dig = tmp % 10;
                digPrd *= dig;
                tmp /= 10;
            }

            if(digPrd % t == 0){
                return n;
            }
            n++;
        }
    }
}