/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    
    public List<List<Integer>> traverse(Node root){
        
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        List<Node> list;
        
        if(root==null)
            return result;
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            
            while(size!=0){

                Node node = queue.remove();
                size--;

                tmp.add(node.val);
                list = node.children;

                while(!list.isEmpty()){
                    node = list.remove(0);
                    if(node!=null)
                        queue.add(node);
                }

            }
            result.add(tmp);
        }
        
        return result;
    }
    
    public List<List<Integer>> levelOrder(Node root) {
        return traverse(root);
    }
}