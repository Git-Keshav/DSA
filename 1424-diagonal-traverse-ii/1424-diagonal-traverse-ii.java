class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<List<Integer>> diagonals = new ArrayList<>();
        
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int diagonalSum = i + j;
                
                while (diagonals.size() <= diagonalSum) {
                    diagonals.add(new ArrayList<>());
                }
                
                diagonals.get(diagonalSum).add(nums.get(i).get(j));
            }
        }
        
        int totalElements = 0;
        for (List<Integer> diag : diagonals) {
            totalElements += diag.size();
        }
        
        int[] result = new int[totalElements];
        int idx = 0;
        
        for (List<Integer> diag : diagonals) {
            for (int i = diag.size() - 1; i >= 0; i--) {
                result[idx++] = diag.get(i);
            }
        }
        
        return result;
    }
}