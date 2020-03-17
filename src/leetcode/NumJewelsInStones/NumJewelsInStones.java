package leetcode.NumJewelsInStones;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode #771
 * https://leetcode.com/problems/jewels-and-stones/
 */
public class NumJewelsInStones {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String J = "aA";
        String S = "aAAbbbb";
        int num = solution.numJewelsInStones(J, S);
        System.out.println(num);

        J = "z";
        S = "ZZZZ";
        num = solution.numJewelsInStones(J, S);
        System.out.println(num);

        J = null;
        S = "ZZZZ";
        num = solution.numJewelsInStones(J, S);
        System.out.println(num);

        J = "abc";
        S = "a";
        num = solution.numJewelsInStones(J, S);
        System.out.println(num);

    }
}

class Solution {
    public int numJewelsInStones(String J, String S) {
        int jewelNum = 0;
        if (J == null || J.length() <= 0) {
            return jewelNum;
        }
        Set jewelSet = new HashSet();

        for (char c : J.toCharArray()) {
            jewelSet.add(c);
        }
        for (char c : S.toCharArray()) {
            if (jewelSet.contains(c)) {
                jewelNum ++;
            }
        }
        return jewelNum;
    }
}

