public class Problem_1022_day20 {
    public static void main(String[] args) {

        /*
                1
               / \
              0   1
             / \   \
            0   1   1

        Binary Numbers:
        100 -> 4
        101 -> 5
        111 -> 7

        Output = 4 + 5 + 7 = 16
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);

        Solution sol = new Solution();
        int result = sol.sumRootToLeaf(root);

        System.out.println("Sum of Root to Leaf Binary Numbers: " + result);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int current) {
        if (node == null) return 0;

        current = current * 2 + node.val;

        // If leaf node, return the binary number formed
        if (node.left == null && node.right == null)
            return current;

        return dfs(node.left, current) + dfs(node.right, current);
    }
}
