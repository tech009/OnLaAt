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
    
    public void read(HashMap<Integer, PriorityQueue<Integer>> map, TreeNode root, int col){
        
        if(map.containsKey(col)){
            PriorityQueue<Integer> queue = map.get(col);
            queue.add(root.val);
            map.put(col, queue);
        }
        else{
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            queue.add(root.val);
            map.put(col, queue);
        }
        
        if(root.left!=null)
            read(map, root.left, col-1);
        if(root.right!=null)
            read(map, root.right, col+1);
    }
    
    public int traverse(TreeNode root, int min, int calc){
        
        int a=min, b=min;
        
        if(calc==0){
            if(root.left!=null)
                a=traverse(root.left, min-1, 0);
            if(root.right!=null)
                b=traverse(root.right, min+1, 0);
            
            if(a<b)
                return a;
            return b;
        }
        
        else{
            if(root.left!=null)
                a=traverse(root.left, min-1, 1);
            if(root.right!=null)
                b=traverse(root.right, min+1, 1);
            
            if(a>b)
                return a;
            return b;
        }
        
    }
    
    public List<List<Integer>> calc(TreeNode root){
        int min = traverse(root, 0, 0);
        int max = traverse(root, 0, 1);
        
        HashMap <Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();
        read(map, root, 0);
        
        List<List<Integer>> res = new ArrayList<>();
        int count = min;
        while(count<=max){
            List<Integer> list = new ArrayList<>();
            PriorityQueue<Integer> queue = map.get(count);
            while(!queue.isEmpty())
                list.add(queue.remove());
            res.add(list);
            count++;
        }
        return res;
        
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        return calc(root);
    }
}