import java.util.HashMap;
import java.util.Map;

class Solution {
    
    class SeatRow {
        boolean leftFree = true;   // Seats 2,3,4,5
        boolean rightFree = true;  // Seats 6,7,8,9
        boolean middleFree = true; // Seats 4,5,6,7

        public void reserveSeat(int seat) {
            if (seat >= 2 && seat <= 5) leftFree = false;
            if (seat >= 6 && seat <= 9) rightFree = false;
            if (seat >= 4 && seat <= 7) middleFree = false;
        }

        public int getMaxGroups() {
            if (leftFree && rightFree) {
                return 2; 
            } else if (leftFree || middleFree || rightFree) {
                return 1;
            }
            return 0;
        }
    }

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, SeatRow> activeRows = new HashMap<>();
        
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int seatNum = seat[1];
            
            activeRows.putIfAbsent(row, new SeatRow());
            
            activeRows.get(row).reserveSeat(seatNum);
        }
        
        int emptyRows = n - activeRows.size();
        int totalGroups = emptyRows * 2;
        
        for (SeatRow rowInfo : activeRows.values()) {
            totalGroups += rowInfo.getMaxGroups();
        }
        
        return totalGroups;
    }
}