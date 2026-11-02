class Solution {
    private static final Random RANDOM = new Random();
    public int minMoves2(int[] nums) {
        int n = nums.length;
        int targetInd = n/2;
        int median = findSmallest(nums, targetInd);

        int totalMoves = 0;
        for(int num : nums){
            totalMoves += Math.abs(num - median);
        }
        return totalMoves;
    }

    private static int findSmallest(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            int randomInd = left + RANDOM.nextInt(right - left + 1);
            int pivotValue = arr[randomInd];

            int less = left;
            int current = left;
            int greater = right;

            while(current <= greater){
                if(arr[current] < pivotValue){
                    swap(arr, less, current);
                    less++;
                    current++;
                }else if( arr[current] > pivotValue){
                    swap(arr, current, greater);
                    greater--;
                }else{
                    current++;
                }
            }

            if(k < less){
                right = less - 1;
            }else if(k > greater){
                left = greater +1;
            }else{
                return pivotValue;
            }
        }
        return -1;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}