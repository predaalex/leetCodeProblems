package main.java;

import java.util.HashSet;

public class TwoSumIV {
    public static void main(String[] args) {
        PathSum.TreeNode root = new PathSum.TreeNode(3);


        findTarget(root, 13);
    }

    private static boolean findTarget(PathSum.TreeNode root, int k) {
        HashSet<Integer> hashSet = new HashSet<>();

        return dfs(root, hashSet, k);
    }

    private static boolean dfs(PathSum.TreeNode root, HashSet<Integer> hashSet, int k) {
        if(root == null)
            return false;

        if(hashSet.contains(k - root.val))
            return true;

        hashSet.add(root.val);
        return dfs(root.left, hashSet, k) || dfs(root.right, hashSet, k);
    }
}
