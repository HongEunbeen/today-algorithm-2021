/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        Queue<Node> queue= new LinkedList<>();
        if(root != null) queue.offer(root);
        while(!queue.isEmpty()){
            int qs=queue.size();
            LinkedList<Node> nodeList= new LinkedList<>();
            
            for(int i=0; i<qs; i++){
                Node current = queue.poll();
                
                nodeList.add(current);
                if(current.left!=null) queue.offer(current.left);
                if(current.right!=null) queue.offer(current.right);
            }
            if(nodeList.size()>0){
                int i=1;
                while(i<nodeList.size()){
                    nodeList.get(i-1).next=nodeList.get(i++);
                }
                nodeList.get(nodeList.size()-1).next=null;
            }
        }
        
        return root;
    }
}
