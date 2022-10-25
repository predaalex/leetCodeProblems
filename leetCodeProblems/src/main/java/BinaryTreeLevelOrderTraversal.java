//        102. Binary Tree Level Order Traversal
//
//        Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
//===========================================================================
//        Example 1:
//        Input: root = [3,9,20,null,null,15,7]
//        Output: [[3],[9,20],[15,7]]
//---------------------------------------------------------------------------
//        Example 2:
//        Input: root = [1]
//        Output: [[1]]
//---------------------------------------------------------------------------
//        Example 3:
//        Input: root = []
//        Output: []

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        PathSum.TreeNode root = new PathSum.TreeNode(3);
        root.left = new PathSum.TreeNode(9);
        root.right = new PathSum.TreeNode(20);
        root.right.left = new PathSum.TreeNode(15);
        root.right.right = new PathSum.TreeNode(7);

        System.out.println(levelOrder(root));
    }

    private static List<List<Integer>> levelOrder(PathSum.TreeNode root) {
        List<List<Integer>> tree = new ArrayList<>();

        int height = 0;

        if (root == null)
            return tree;

        listCreation(root, height, tree);

        return tree;
    }

    public static void listCreation(PathSum.TreeNode node, int height, List<List<Integer>> tree) {
        height++;
        int val = node.val;

        if (tree.size() < height) {
            List<Integer> level = new ArrayList<>();
            level.add(val);
            tree.add(level);
        } else {
            tree.get(height - 1).add(val);
        }

        if (node.left != null)
            listCreation(node.left, height, tree);
        if (node.right != null)
            listCreation(node.right, height, tree);

    }
}
