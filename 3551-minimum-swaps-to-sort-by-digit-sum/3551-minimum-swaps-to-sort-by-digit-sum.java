class Solution {
    static class Element{
        int val;
        int sum;
        int OrgInd;

        Element(int val, int sum, int OrgInd){
            this.val = val;
            this.sum = sum;
            this.OrgInd = OrgInd;
        }
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;
        Element[] arr = new Element[n];
        
        for(int i =0; i< n; i++){
            arr[i] = new Element(nums[i], digitSum(nums[i]), i);
        }

        Arrays.sort(arr, (a, b) ->{
            if(a.sum != b.sum){
                return Integer.compare(a.sum, b.sum);
            }
            return Integer.compare(a.val, b.val); 
        });

        boolean[] visited = new boolean[n];
        int swapCnt = 0;

        for(int i = 0; i< n; i++){
            if(visited[i] || arr[i].OrgInd == i){
                continue;
            }
            int cyclesize = 0;
            int curr = i;

            while (!visited[curr]){
                visited[curr] = true;
                curr = arr[curr].OrgInd;
                cyclesize++;
            }
            if(cyclesize > 1){
                swapCnt += (cyclesize -1);
            }
        }
        return swapCnt;
    }

    private int digitSum(int num){
        int sum = 0;
        while(num> 0){
            sum += num %10;
            num  /= 10;
        }
        return sum;
    }
}