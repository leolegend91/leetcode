package leetcode.LongestValidParentheses;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "(()";
        System.out.println(solution.longestValidParentheses(s));
        s="(()()";
        System.out.println(solution.longestValidParentheses(s));
        s="(()((()))";
        System.out.println(solution.longestValidParentheses(s));
        s="(()(()))))()";
        System.out.println(solution.longestValidParentheses(s));
        s="";
        System.out.println(solution.longestValidParentheses(s));
        s=null;
        System.out.println(solution.longestValidParentheses(s));
        s="()(()";
        System.out.println(solution.longestValidParentheses(s));
        s="()(())";
        System.out.println(solution.longestValidParentheses(s));
    }
}

class Solution {
    public int longestValidParentheses(String s) {
        if (s == null) {
            return 0;
        }
        int[] flag = new int[s.length()];
        // 全局最大值
        int longestSize = 0;
        // 局部最大值
        int tmpLognestSize = 0;
        // 入栈的左括号数量
        int leftCount = 0;
        for (int i = 0;i < s.length();i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftCount++;
                flag[i] = 0;
            } else if (c == ')') {
                if (leftCount <= 0) {
                    flag[i] = 0;
                } else {
                    leftCount--;
                    flag[i] = 1;
                }
            }
        }

        int positiveNum = 0;
        for (int i = s.length() - 1;i >=0;i--) {
            if (flag[i] == 1) {
                positiveNum ++;
                tmpLognestSize++;
            } else if (positiveNum > 0) {
                positiveNum--;
                tmpLognestSize++;
            } else {
                longestSize = longestSize > tmpLognestSize ? longestSize : tmpLognestSize;
                tmpLognestSize = 0;
            }
        }
        longestSize = longestSize > tmpLognestSize ? longestSize : tmpLognestSize;
        return longestSize;


    }
}