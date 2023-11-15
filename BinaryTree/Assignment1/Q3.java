import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// Q3(515. Find Largest Value in Each Tree Row)
// https://leetcode.com/problems/find-largest-value-in-each-tree-row/
class Q3 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>();

        if (root == null){
            return resList;
        }

        que.offer(root);

        while(!que.isEmpty()){
            List<Integer> levelList = new ArrayList<>();
            int len = que.size();
            int max = Integer.MIN_VALUE;

            while(len > 0){
                TreeNode cur = que.poll();
                levelList.add(cur.val);

                if(cur.left != null ) que.offer(cur.left);
                if(cur.right != null ) que.offer(cur.right);

                max = Math.max(max,cur.val); // 这是卡住的地方。
                len--;
            }
            resList.add(max);
        }
        return resList;
    }

    public static void main(String[] args) {
        // TEST CASE
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = null;
        root.right.right = new TreeNode(9);

        Q3 q3 = new Q3();

        List largestValues = q3.largestValues(root);
        System.out.println("The found Largest Value in This Tree Row: " + largestValues);
    }
}