class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> tempRes = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        while(i < n && intervals[i][1] < newInterval[0]){
            tempRes.add(intervals[i]);
            i++;
        }
        while(i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        tempRes.add(newInterval);

        while(i < n){
            tempRes.add(intervals[i]);
            i++;
        }
        return tempRes.toArray(new int[tempRes.size()][]);

    }
}