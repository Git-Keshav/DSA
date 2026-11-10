class Solution {
    public int climbStairs(int n, int[] costs) {
      int Fstep = 0, Sstep = 0, Tstep = 0;

      for(int i : costs){
        int next = Math.min(Fstep + 9, Math.min(Sstep + 4, Tstep + 1)) + i;

        Fstep = Sstep;
        Sstep = Tstep;
        Tstep = next;
      }
      return Tstep;
    }
}