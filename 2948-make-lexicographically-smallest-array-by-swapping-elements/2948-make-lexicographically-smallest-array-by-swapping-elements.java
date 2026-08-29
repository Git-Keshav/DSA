class Solution {
    static class Pair{
        int value;
        int index;

        Pair(int value, int index){
            this.value = value;
            this.index = index;
        }

    }
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        ArrayList<Pair> list = new ArrayList<>();

        for(int i = 0; i <nums.length; i++){
            list.add(new Pair(nums[i], i));
        }

        list.sort((a,b) -> Integer.compare(a.value, b.value));

        int start = 0;

        while (start < list.size()){
            int end = start;
            while(end +1 < list.size() && list.get(end + 1).value - list.get(end).value <= limit){
                end++;
            }

            ArrayList<Integer> ind = new ArrayList<>();

            for(int i = start; i <= end; i++){
                ind.add(list.get(i).index);
            }

            Collections.sort(ind);

            for(int i = 0; i < ind.size(); i++){
                nums[ind.get(i)] = list.get(start + i).value;
            }
            start = end +1;
        }

        return nums;

    }
}