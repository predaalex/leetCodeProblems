package main.java;//        113. Path Sum II
//        A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
//--------------------------------------------------------------------------------------------
//        Example 1:
//
//        Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//        Output: [[5,4,11,2],[5,8,4,5]]
//        Explanation: There are two paths whose sum equals targetSum:
//        5 + 4 + 11 + 2 = 22
//        5 + 8 + 4 + 5 = 22

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public static void main(String[] args) {
        PathSum.TreeNode root = new PathSum.TreeNode(5);
        root.left = new PathSum.TreeNode(4);
        root.left.left = new PathSum.TreeNode(11);
        root.left.left.left = new PathSum.TreeNode(7);
        root.left.left.right = new PathSum.TreeNode(2);
        root.right = new PathSum.TreeNode(8);
        root.right.left = new PathSum.TreeNode(13);
        root.right.right = new PathSum.TreeNode(4, new PathSum.TreeNode(5), new PathSum.TreeNode(1));

        int targetSum = 22;
        System.out.println("listList -> " + pathSum(root, targetSum));
    }

    private static List<List<Integer>> pathSum(PathSum.TreeNode root, int targetSum) {

        List<List<Integer>> listList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        pathSumII(root, targetSum, 0, listList, list);
        return listList;
    }

    private static void pathSumII(PathSum.TreeNode root, int targetSum, int sum,
                                  List<List<Integer>> listList, List<Integer> list) {
        if(root == null) return;

        sum += root.val;
        list.add(root.val);
        if(root.left == null && root.right == null && sum == targetSum){
            System.out.println(list + " -> " + sum);
            listList.add(new ArrayList<>(list));
        }
        if(root.left != null)
            pathSumII(root.left, targetSum, sum, listList, list);
        if(root.right != null)
            pathSumII(root.right, targetSum, sum, listList, list);

        if(list.size() > 0)
            list.remove(list.size() - 1);
    }
}
