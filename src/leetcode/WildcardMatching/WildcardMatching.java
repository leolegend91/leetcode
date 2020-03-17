package leetcode.WildcardMatching;

/**
 * https://leetcode.com/problems/wildcard-matching/
 */
public class WildcardMatching {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aa";
        String p = "a";
        // false
        System.out.println(solution.isMatch(s, p));
        s = "aa";
        p = "*";
        // true
        System.out.println(solution.isMatch(s, p));
        s = "cb";
        p = "*a";
        // false
        System.out.println(solution.isMatch(s, p));
        s = "adceb";
        p = "*a*b";
        // true
        System.out.println(solution.isMatch(s, p));
        s = "acdcb";
        p = "a*c?b";
        // false
        System.out.println(solution.isMatch(s, p));
        s = "a";
        p = "a***?";
        // false
        System.out.println(solution.isMatch(s, p));
        s = "a";
        p = "***?";
        // true
        System.out.println(solution.isMatch(s, p));
        s = "acd";
        p = "m*d";
        // false
        System.out.println(solution.isMatch(s, p));
        s = "";
        p = "a";
        // false
        System.out.println(solution.isMatch(s, p));
        s = "a";
        p = "aa";
        // false
        System.out.println(solution.isMatch(s, p));
        s = "mississippi";
        p = "m??*ss*?i*pi";
        // false
        System.out.println(solution.isMatch(s, p));
    }

}

class Solution {
    public boolean isMatch(String s, String p) {
        if (s.equals(p) || ("*").equals(p)) {
            return true;
        }
        if (p == null || ("").equals(p)) {
            return false;
        }
        if (s == null || ("").equals(s)) {
            return false;
        }
        boolean[][] matchMatrix = new boolean[s.length()][p.length()];
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        matchMatrix[0][0] = pArray[0] == '?' || pArray[0] == '*' || pArray[0] == sArray[0];
        int starNum = pArray[0] == '*' ? 1 : 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    if (pArray[j] == '*') {
                        starNum ++;
                        matchMatrix[i][j] = matchMatrix[i][j - 1];
                    } else if (pArray[j] == '?' || pArray[j] == sArray[i]) {
                        matchMatrix[i][j] = matchMatrix[i][j - 1] && ((j - starNum) < 1);
                    } else {
                        matchMatrix[i][j] = false;
                    }
                } else if (j == 0) {
                    if (pArray[j] == '*') {
                        matchMatrix[i][j] = true;
                    } else {
                        matchMatrix[i][j] = false;
                    }
                } else {
                    if (pArray[j] == '*') {
                        matchMatrix[i][j] = matchMatrix[i][j - 1] || matchMatrix[i - 1][j] || matchMatrix[i - 1][j - 1];
                    } else if (pArray[j] == '?') {
                        matchMatrix[i][j] = matchMatrix[i - 1][j - 1];
                    } else if (pArray[j] == sArray[i]){
                        matchMatrix[i][j] = matchMatrix[i - 1][j - 1];
                    } else {
                        matchMatrix[i][j] = false;
                    }
                }
            }
        }
        return matchMatrix[s.length() - 1][p.length() - 1];
    }
}