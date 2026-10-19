/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>();
        }

        Map<Integer, List<TreeNode>> memo = new HashMap<>();
        return build(n, memo);
    }

    private List<TreeNode> build(int n, Map<Integer, List<TreeNode>> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        List<TreeNode> result = new ArrayList<>();

        if (n == 1) {
            result.add(new TreeNode(0));
            return result;
        }

        for (int leftCount = 1; leftCount < n; leftCount += 2) {
            int rightCount = n - 1 - leftCount;

            List<TreeNode> leftTrees = build(leftCount, memo);
            List<TreeNode> rightTrees = build(rightCount, memo);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    result.add(new TreeNode(0, left, right));
                }
            }
        }

        memo.put(n, result);
        return result;
    }
}