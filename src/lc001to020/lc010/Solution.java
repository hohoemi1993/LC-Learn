package lc001to020.lc010;


public class Solution {

    public boolean isMatch001(String s, String p) {

        if(p.equals("*")) return false;

        if (p.length() > s.length()) return false;

        return isMatch(s.toCharArray(),p.toCharArray(),0,0);
    }

    private boolean isMatch(char[] text, char[] patten, int i, int j) {
        if (j == patten.length) return i == text.length;

        if (patten[j] == '.') {
            if ( j+1 < patten.length && patten[j+1] == '*' ) {
                return true;
            }
            else {
                return isMatch(text, patten, ++i, ++j);
            }
        }

        if (text[i] == patten[j] && patten[j] != '.') {
            if (j+1 < patten.length && patten[j+1] == '*' ) {
                if (i + 1 < text.length && text[i] == text[i + 1] )
                    return isMatch(text, patten, i + 1, j);
            }
            else
                return isMatch(text, patten, ++i, ++j);
        }

        return false;
    }

    // *************************************************************//

    public boolean isMatch002(String s, String p) {

        if( p.length() == 0 )  return s.length() == 0;

        // second char is *
        if (p.length() > 1 && p.charAt(1) == '*') {
            // deal with '*' and char before '*' repeat zero time
            if(isMatch002(s,p.substring(2)))
                return true;
            //
            if(s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)))
                return isMatch002(s.substring(1), p);

            return false;
        }
        // second char is not '*'
        else {
            if(s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)))
                return isMatch002(s.substring(1), p.substring(1));
            return false;
        }
    }

    /**
     * dynamic programming
     * T O(n^2)
     * S O(n^2)
     */
    public boolean isMatch003(String s, String p) {

        if ( null == s || null == p) return false;

        // dp[i][j] represent length of s is i and length of p is j
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        // empty s and p is matched
        dp[0][0] = true;
        // d[0][j] represent empty s and p like a*b*c*
        for (int j=2;j<=p.length();++j){
            dp[0][j] = dp[0][j-2] && p.charAt(j-1) == '*';
        }

        // two situation
        // the one is that the current char of p equals the current char of s or '.'
        // the other is that current char of p equals '*'
        for (int j=1; j <= p.length(); ++j){
            for (int i=1 ; i <= s.length() ; ++i) {
                if (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.')
                    dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1) == '*'){
                    // a* repeat zero times dp[i][j] just depends on dp[i][j-2]
                    // a* repeat 1 times dp[i][j] depends on dp[i-1][j]
                    // dp[i-1][j] rely on dp[i-2][j] can include a* repeat n times
                    dp[i][j] = dp[i][j-2] || ((p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) =='.') && dp[i-1][j]);
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
