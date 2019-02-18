package lc001to020.lc017;

import java.util.*;

/**
 * Created on 2019/2/18<br>
 *
 * @author dengxingda
 * @version 1.0
 */
public class Solution {

    private Map<String, String> phone = new HashMap<>();

    {
        phone.put("2", "abc");
        phone.put("3", "def");
        phone.put("4", "ghi");
        phone.put("5", "jkl");
        phone.put("6", "mno");
        phone.put("7", "pqrs");
        phone.put("8", "tuv");
        phone.put("9", "wxyz");
    }

    /**
     * recursion
     */
    public List<String> letterCombinations001(String digits) {
        List<String> result = new ArrayList<>(digits.length() << 2);

        if (digits.length() == 0 ) return result;

        backtracking("",digits, result);

        return result;

    }

    private void backtracking(String comb, String next, List<String> result) {
        if (next.length() == 0) result.add(comb);

        else {
            String digit = next.substring(0,1);
            String letters = phone.get(digit);
            for (int i=0; i< letters.length(); ++i) {
                backtracking(comb + letters.charAt(i),next.substring(1),result);
            }
        }
    }

    // ***************************************************************************************** //

    /**
     * FIFO queue
     */
    public List<String> letterCombinations002(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if (digits.isEmpty()) return result;

        result.add("");

        for (int i=0; i<digits.length(); ++i) {
            String number = digits.substring(i, i + 1);
            char[] letters = phone.get(number).toCharArray();

            while (result.peek().length() == i) {
                String temp = result.remove();
                for (char letter : letters)
                    result.add(temp + letter);
            }
        }
        return result;
    }

    /**
     * BFS
     */
    public List<String> letterCombinations003(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if (digits.isEmpty()) return result;

        result.add("");

        while (result.peek().length() != digits.length()) {
            String temp = result.remove();
            String number = digits.substring(temp.length(),temp.length()+1);
            char[] letters = phone.get(number).toCharArray();
            for (char letter : letters) {
                result.addLast(temp + letter);
            }
        }
        return result;
    }
}
