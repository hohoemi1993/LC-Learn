package lc001to020.lc006;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dengxingda
 */
public class Solution {
    public String convert001(String s, int numRows) {
        int len = s.length();
        if (len == 0) return "";
        if (numRows == 1) return s;
        if (len < numRows) return s;

        List<StringBuilder> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; ++i) {
            rows.add(new StringBuilder());
        }


        int currentRow = 0;
        boolean down = false;
        for (int i = 0; i < len; ++i) {
            rows.get(currentRow).append(s.charAt(i));
            if (currentRow == 0 || currentRow == numRows - 1)
                down = !down;
            currentRow += down ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder builder : rows) {
            result.append(builder);
        }

        return result.toString();
    }
}
