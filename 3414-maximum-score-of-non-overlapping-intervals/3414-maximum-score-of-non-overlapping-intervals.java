class Solution {
    static class Interval{
        int st, end, wei, id;

        public Interval(int st, int end, int wei, int id){
            this.st = st;
            this.end = end;
            this.wei = wei;
            this.id = id;
        }
    }
    static class Result{
        long sc;
        List<Integer> ind;

        public Result(long sc, List<Integer> ind){
            this.sc = sc;
            this.ind = ind;
        }
    }
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        Interval[] arr = new Interval[n];
        for(int i = 0; i < n; i++){
            List<Integer> interval = intervals.get(i);
            arr[i] = new Interval(interval.get(0), interval.get(1), interval.get(2), i);
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a.st));
        Result[][] memo = new Result[n][5];
        Result res = solve(0, 4, arr, memo);

        return res.ind.stream().mapToInt(i -> i).toArray();
    }

    private Result solve(int i, int k, Interval[] arr, Result[][] memo){
        if(k == 0 || i == arr.length){
            return new Result(0, new ArrayList<>());
        }
        if(memo[i][k] != null){
            return memo[i][k];
        }
        Result skip = solve(i+1, k, arr, memo);

        int nextI = findNext(arr, arr[i].end);
        Result takeSub = solve(nextI, k -1, arr, memo);

        long takeSc = arr[i].wei + takeSub.sc;
        List<Integer> takeInd = new ArrayList<>(takeSub.ind);
        takeInd.add(arr[i].id);
        Collections.sort(takeInd);
        Result take = new Result(takeSc, takeInd);

        memo[i][k] = getBetter(take, skip);
        return memo[i][k];
    }

    private int findNext(Interval[] arr,int targetEnd){
        int left =0;
        int right = arr.length -1;
        int ans = arr.length;
        while(left <= right){
            int mid = left + (right - left) /2;
            if(arr[mid].st > targetEnd){
                ans = mid;
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }
    private Result getBetter(Result a, Result b){
        if(a.sc !=b.sc){
            return a.sc > b.sc ? a:b;
        }
        int minSize = Math.min(a.ind.size(), b.ind.size());
        for(int i = 0; i< minSize; i++){
            if(!a.ind.get(i).equals(b.ind.get(i))){
                return a.ind.get(i) < b.ind.get(i) ? a:b;
            }
        }
        return a.ind.size() < b.ind.size() ? a:b;
    }
}