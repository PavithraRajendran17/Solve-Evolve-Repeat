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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
           return build(preorder, inorder, 0, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (preStart >= preorder.length || inStart > inEnd) {
            return null;
        }

        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        int index = inStart;

        while (inorder[index] != rootValue) {
            index++;
        }

        int leftSize = index - inStart;

        root.left = build(preorder, inorder, preStart + 1, inStart, index - 1);

        root.right = build(preorder, inorder, preStart + leftSize + 1, index + 1, inEnd);

        return root;
        
    }
}
