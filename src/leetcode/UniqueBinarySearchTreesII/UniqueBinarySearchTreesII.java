package leetcode.UniqueBinarySearchTreesII;

import java.util.LinkedList;
import java.util.List;

import leetcode.TreeNode;

/**
 * https://leetcode.com/problems/unique-binary-search-trees-ii
 */
public class UniqueBinarySearchTreesII {
    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode.printTreeNodesMidOrder(solution.generateTrees(0));
        System.out.println();
        TreeNode.printTreeNodesMidOrder(solution.generateTrees(1));
        System.out.println();
        TreeNode.printTreeNodesMidOrder(solution.generateTrees(2));
        System.out.println();
        TreeNode.printTreeNodesMidOrder(solution.generateTrees(3));
        System.out.println();
    }

}

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new LinkedList<TreeNode>();
        }
        List<TreeNode> result = new LinkedList<TreeNode>();
        result.add(new TreeNode(1));
        for (int i = 2;i <= n;i++) {
            List<TreeNode> list1 = addTreeNodeOnRoot(result, i);
            List<TreeNode> list2 = addTreeNodeOnChild(result, i);
            result = new LinkedList<TreeNode>();
            result.addAll(list1);
            result.addAll(list2);
        }
        return result;
    }

    public List<TreeNode> addTreeNodeOnRoot(List<TreeNode> treeNodes, int i) {
        List<TreeNode> result = new LinkedList<TreeNode>();
        for (TreeNode treeNode : treeNodes) {
            TreeNode rootNode = new TreeNode(i);
            rootNode.left = treeNode;
            result.add(rootNode);
        }
        return result;
    }

    public List<TreeNode> addTreeNodeOnChild(List<TreeNode> treeNodes, int i) {
        List<TreeNode> result = new LinkedList<TreeNode>();
        for (TreeNode treeNode : treeNodes) {
            TreeNode currentNode = treeNode;
            int height = 0;
            while(currentNode != null) {
                currentNode = currentNode.right;
                height++;
            }
            // copy height rightNodePath, to insert new node
            List<TreeNode> rightTree = new LinkedList<TreeNode>();
            for (int h = 0; h < height; h++) {
                TreeNode node = treeNode;
                TreeNode newRootNode = new TreeNode(node.val);
                TreeNode newNode = newRootNode;
                newNode.left = node.left;
                // node goto next level, newNode on current level
                node = node.right;
                while (node != null) {
                    newNode.right = new TreeNode(node.val);
                    // node on next level
                    newNode = newNode.right;
                    // newNode goto next level
                    newNode.left = node.left;
                    // node goto next next level
                    node = node.right;
                }
                rightTree.add(newRootNode);
            }
            for (int h = 0;h < height; h++) {
                TreeNode node = rightTree.get(h);
                int hTmp = h;
                while (hTmp > 0) {
                    hTmp--;
                    node = node.right;
                }
                TreeNode rightNode = node.right;
                node.right = new TreeNode(i);
                node.right.left = rightNode;
            }
            result.addAll(rightTree);
        }
        return result;
    }
}