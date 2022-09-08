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
    public void traverse(TreeNode root, StringBuilder sb){
        sb.append(root.val);
        
        if((root.left==null)&&(root.right!=null))
            sb.append("()");
        else if(root.left!=null){
            sb.append("(");
            traverse(root.left, sb);
            sb.append(")");
        }
        
        if(root.right!=null){
            sb.append("(");
            traverse(root.right, sb);
            sb.append(")");
        }
    }
    
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        return sb.toString();
    }
}