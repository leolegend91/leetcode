package leetcode;

import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    public static void printTreeNodeMidOrder(TreeNode t) {
        if (t == null) {
            System.out.print("null, ");
            return;
        }
        System.out.print(t.val);
        System.out.print(", ");
        printTreeNodeMidOrder(t.left);
        printTreeNodeMidOrder(t.right);
    }



    public static void printTreeNodesMidOrder(List<TreeNode> treeNodeList) {
        for (TreeNode treeNode : treeNodeList) {
            printTreeNodeMidOrder(treeNode);
            System.out.println();
        }
    }

    public static void main(String args[]) {
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;
        printTreeNodeMidOrder(treeNode2);
        System.out.println();

        treeNode2.left = null;
        treeNode2.right = null;
        treeNode3.left = treeNode2;
        treeNode2.left = treeNode1;
        printTreeNodeMidOrder(treeNode3);
    }
}