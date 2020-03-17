package leetcode.RangeSumBST;

import leetcode.TreeNode;

/**
 * leetcode #938
 * https://leetcode.com/problems/range-sum-of-bst/
 */
public class RangeSumBST {
    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = null;
        int L = 7;
        int R = 15;
        int result = solution.rangeSumBST(root, L, R);
        System.out.println(result);


    }

}

class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        } else if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        } else {
            return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
        }
    }
}