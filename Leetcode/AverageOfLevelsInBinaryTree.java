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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<>();
        List<Double> res = new ArrayList<>();
        
        res.add((double)root.val);
        if(root.left!=null)
            q1.add(root.left);
        if(root.right!=null)
            q1.add(root.right);
        
        while(q1.size()!=0){
            int size = q1.size();
            double tmp = 0.0;
            double count = (double)size;
            while(size!=0){
                TreeNode node = q1.remove();
                tmp+=(double)node.val;
                if(node.left!=null)
                    q1.add(node.left);
                if(node.right!=null)
                    q1.add(node.right);
                size--;
            }
            res.add(tmp/count);
        }
        
        return res;
    }
}