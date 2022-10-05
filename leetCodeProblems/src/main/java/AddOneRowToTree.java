//        623. Add One Row to Tree
//        Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.
//
//        Note that the root node is at depth 1.
//
//        The adding rule is:
//
//        Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as cur's left subtree root and right subtree root.
//        cur's original left subtree should be the left subtree of the new left subtree root.
//        cur's original right subtree should be the right subtree of the new right subtree root.
//        If depth == 1 that means there is no depth depth - 1 at all, then create a tree node with value val as the new root of the whole original tree, and the original tree is the new root's left subtree.
//-------------------------------------
//        Example 1:
//
//        Input: root = [4,2,6,3,1,5], val = 1, depth = 2
//        Output: [4,1,1,2,null,null,6,3,1,5]
public class AddOneRowToTree {
    public static void main(String[] args) {
        PathSum.TreeNode root = new PathSum.TreeNode(4);
        root.left = new PathSum.TreeNode(2, new PathSum.TreeNode(3), new PathSum.TreeNode(1));
        root.right = new PathSum.TreeNode(6);
        root.right.left = new PathSum.TreeNode(5);

        int val = 11;
        int row = 1;

        afisTree(addOneRow(root, val, row));
    }

    private static void afisTree(PathSum.TreeNode root) {
        if(root == null)
            return;

        System.out.println(root.val + " ---");

        if(root.left != null)
            afisTree(root.left);
        if(root.right != null)
            afisTree(root.right);

    }

    private static PathSum.TreeNode addOneRow(PathSum.TreeNode root, int val, int depth) {
        if(depth == 1){
            PathSum.TreeNode n = new PathSum.TreeNode(val);
            n.left = root;
            return n;
        }

        addRow(root, val, 0, depth);

        return root;
    }
    public static void addRow(PathSum.TreeNode node, int val, int depth, int row) {

        if(node == null)
            return;

        depth++;

        if(depth == row - 1) {
            PathSum.TreeNode aux = node.left;
            node.left = new PathSum.TreeNode(val);
            node.left.left = aux;

            aux = node.right;
            node.right = new PathSum.TreeNode(val);
            node.right.right = aux;
        }

        if(node.left != null)
            addRow(node.left, val, depth, row);
        if(node.right != null)
            addRow(node.right, val, depth, row);
    }
}

