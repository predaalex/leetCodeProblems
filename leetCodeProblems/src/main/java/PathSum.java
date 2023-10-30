package main.java;//        112. Path Sum
//        Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
//
//        A leaf is a node with no children.
//----------------------------------------------------------------------
//        Example 1:
//
//        Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//        Output: true
//        Explanation: The root-to-leaf path with the target sum is shown.

public class PathSum {
    public static class TreeNode {
     int val;
     TreeNode right;
     TreeNode left;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4, new TreeNode(), new TreeNode());
        root.right = new TreeNode(8, new TreeNode(13), new TreeNode(4));
        root.right.right.right = new TreeNode(1);
        root.left.left = new TreeNode(11, new TreeNode(7), new TreeNode(2));
        int targetSum = 22;

        System.out.println(hasPathSum(root, 0, targetSum));
    }

    private static boolean hasPathSum(TreeNode root,int sum, int targetSum) {

        boolean l, r;

        if(root == null) return false;

        sum += root.val;
        if(root.left == null && root.right == null && sum == targetSum)
            return true;

        r = hasPathSum(root.left, sum, targetSum);
        l = hasPathSum(root.right, sum, targetSum);

        return r | l;
    }
}
