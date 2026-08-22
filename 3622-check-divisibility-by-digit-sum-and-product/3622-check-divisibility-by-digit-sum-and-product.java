class Solution {
    public boolean checkDivisibility(int n) {
        int t = n;
        int digSum = 0;
        while(t>0){
            int a = t % 10;
            digSum = digSum + a;
            t = t / 10;
        }

        int s = n;
        int digProd = 1;
        while(s>0){
            int b = s % 10;
            digProd = digProd * b;
            s = s / 10;
        }


        if((n % (digSum + digProd) == 0)){
            return true;
        }else{
            return false;}

    }
}