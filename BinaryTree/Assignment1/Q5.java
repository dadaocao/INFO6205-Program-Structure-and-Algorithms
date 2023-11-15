// Q5(1302. Deepest Leaves Sum)
// https://leetcode.com/problems/deepest-leaves-sum/
// DFS
class Q5 {
        int maxLevel = -1;
        int sum = 0;

        public int deepestLeavesSum(TreeNode root) {
            dfs(root, 0);
            return sum;
        }

        public void dfs(TreeNode node, int level) {
            if (node == null) {
                return;
            }
            if (level > maxLevel) {
                maxLevel = level;
                sum = node.val;
            } else if (level == maxLevel) {
                sum += node.val;
            }
            dfs(node.left, level + 1);
            dfs(node.right, level + 1);
        }


        public static void main(String[] args) {
            // TEST CASE
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.left.left.left = new TreeNode(7);
            root.right.left = null;
            root.right.right = new TreeNode(6);
            root.right.right.right = new TreeNode(8);

            Q5 q5 = new Q5();

            int deepestLeavesSum = q5.deepestLeavesSum(root);
            System.out.println("Deepest Leaves Sum is: " + deepestLeavesSum);
        }

}