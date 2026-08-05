class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adjLst = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjLst.add(new ArrayList<>());
        }
        for(int[] i: invocations){
            adjLst.get(i[0]).add(i[1]);
        }

        boolean[] isSusp = new boolean[n];
        dfs(k, adjLst, isSusp);

        for(int[] i: invocations){
            int u = i[0];
            int v = i[1];
            if(!isSusp[u] && isSusp[v]){
                List<Integer> Mthds = new ArrayList<>();
                for(int t = 0; t < n; t++){
                    Mthds.add(t);
                }
                return Mthds;
            }

        }

        List<Integer> rem = new ArrayList<>();
        for(int i = 0; i<n; i++){
            if(!isSusp[i]){
                rem.add(i);
            }
        }
        return rem;
    }
    
    private void dfs(int node, List<List<Integer>> adjLst, boolean[] isSusp){
        isSusp[node] = true;
        for(int g : adjLst.get(node)){
            if(!isSusp[g]){
                dfs(g, adjLst, isSusp);
            }
        }
    }
}