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
    
    public int prune(TreeNode root){
        
        int left = 0;
        int right = 0;
        
        if(root.left!=null)
            left += prune(root.left);
        if(root.right!=null)
            right+=prune(root.right);
        
        if(left==0)
            root.left=null;
        
        if(right==0)
            root.right=null;
        
        return (left+right+root.val);
    }
    
    public TreeNode pruneTree(TreeNode root) {
        int x = prune(root);
        if(x==0)
            return null;
        return root;
    }
}