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
    public int traverse(TreeNode root, int numNode, int[] arr){
        arr[(root.val-1)]+=1;
        
        int path = 0;
        if(root.left!=null)
            path+=traverse(root.left, numNode+1, arr);
        
        if(root.right!=null)
            path+=traverse(root.right, numNode+1, arr);
        
        if((root.left==null)&&(root.right==null)){
            if((numNode%2)==0){
                boolean flag = true;
                for(int i: arr){
                    if((i%2)==1){
                        flag = false;
                        break;
                    }
                }
                if(flag)
                    path+=1;
            }
            else{
                int numOdd = 0;
                for(int i: arr)
                    if((i%2)==1)
                        numOdd++;
                if(numOdd==1)
                    path+=1;
            }
        }
        
        arr[root.val-1]-=1;
        return path;
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        return traverse(root, 1, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    }
}