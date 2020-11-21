package lc134加油站;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int enough = 0;
        List<Integer> starts = new ArrayList<>();
        // O(n)
        for (int i = 0; i<gas.length; i++) {
            if (gas[i] - cost[i]>=0) {
                starts.add(i);
            }
            enough = enough + (gas[i] - cost[i]);
        }

        if (enough < 0) return -1;
        int oilTank = 0;
        for (int start : starts) {
            for (int i=0; i<gas.length; i++) {
                int index = (start + i) % gas.length;
                oilTank = oilTank + (gas[index] - cost[index]);
                if (oilTank < 0) {
                    break;
                }
            }
            if (oilTank >= 0) {
                return start;
            }
            oilTank = 0;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = new int[] {5,1,2,3,4};
        int[] cost = new int[] {4,4,1,5,1};
        Solution solution = new Solution();
        int i = solution.canCompleteCircuit(gas, cost);
        System.out.println(i);


    }
}
