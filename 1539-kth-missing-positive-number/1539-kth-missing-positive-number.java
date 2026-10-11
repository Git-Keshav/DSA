class Solution {
    public int findKthPositive(int[] arr, int k) {
        int cnt = 0;
        int i = 0;
        int num = 1;
        while(true){
            if(i < arr.length && arr[i] == num){
                i++;
            }else{
                cnt++;
                if(cnt == k){
                    return num;
                }
            }
            num++;
        }
    }
}