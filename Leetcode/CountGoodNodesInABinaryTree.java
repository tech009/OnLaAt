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
    
    public int count(TreeNode root, int max){
        int sum = 0;
        if(root==null)
            return 0;
        else if(max<=root.val){
            sum++;
            max = root.val;
        }
        
        sum+=count(root.left, max);
        sum+=count(root.right, max);
        return sum;
    }
    
    public int goodNodes(TreeNode root) {
        return (1+count(root.left, root.val)+count(root.right, root.val));
    }
}