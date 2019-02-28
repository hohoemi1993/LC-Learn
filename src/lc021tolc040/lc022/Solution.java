package lc021tolc040.lc022;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019/2/28<br>
 *
 * @author dengxingda
 * @version 1.0
 */
public class Solution {

    /**
     * recursion
     */
    public List<String> generateParenthesis001(int n) {
        List<String> ans = new ArrayList<>();
        generate001(ans, "", n, n);
        return ans;
    }
    private void generate001(List<String> list, String s, int l, int r) {
        if (l ==0 && r == 0) {
            list.add(s);
            return;
        }

        if(l > 0) generate001(list, s+"(", l-1, r);
        if(r > l) generate001(list, s+")", l, r-1);
    }


}
