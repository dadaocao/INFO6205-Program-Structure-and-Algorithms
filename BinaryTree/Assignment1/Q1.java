// Q1(111. Minimum Depth of Binary Tree)
// https://leetcode.com/problems/minimum-depth-of-binary-tree/
class Q1 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (root.left == null) {
            return rightDepth + 1;
        }
        if (root.right == null) {
            return leftDepth + 1;
        }
        // 左右结点都不为null
        return Math.min(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        // TEST CASE
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Q1 q1 = new Q1();

        int minDepth = q1.minDepth(root);
        System.out.println("Minimum Depth of the Tree: " + minDepth);
    }
}