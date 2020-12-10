package lc860柠檬水找零;

public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] wallet = new int[2];

        for (int bill : bills) {
            if (5 == bill) {
                wallet[0]++;
            }
            else if (10 == bill) {
                if (wallet[0] <= 0) {
                    return false;
                } else {
                    wallet[0]--;
                }
                wallet[1]++;
            } else if (20 == bill) {
                if (wallet[0] <= 0) {
                    return false;
                } else if (wallet[1] > 0) {
                    wallet[1]--;
                    wallet[0]--;
                } else if (wallet[0] > 2) {
                    wallet[0] = wallet[0] - 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
