import java.util.*;

// Q6(366. Find Leaves of Binary Tree)
// https://leetcode.com/problems/find-leaves-of-binary-tree/

import java.util.*;

class Q6 {
    private List<Map.Entry<Integer, Integer>> pairs;

    private int getHeight(TreeNode root) {
        if (root == null) return -1;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        int currHeight = Math.max(leftHeight, rightHeight) + 1;

        this.pairs.add(new AbstractMap.SimpleEntry<>(currHeight, root.val));

        return currHeight;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        this.pairs = new ArrayList<>();
        getHeight(root);

        Collections.sort(this.pairs, Comparator.comparing(Map.Entry::getKey));

        int n = this.pairs.size(), height = 0, i = 0;

        List<List<Integer>> solution = new ArrayList<>();

        while (i < n) {
            List<Integer> nums = new ArrayList<>();
            while (i < n && this.pairs.get(i).getKey() == height) {
                nums.add(this.pairs.get(i).getValue());
                i++;
            }
            solution.add(nums);
            height++;
        }
        return solution;
    }

    public static void main(String[] args) {
        // TEST CASE
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Q6 q1 = new Q6();
        List<List<Integer>> findLeaves = q1.findLeaves(root);
        System.out.println("Find Leaves of Binary Tree: " + findLeaves);
    }
}
