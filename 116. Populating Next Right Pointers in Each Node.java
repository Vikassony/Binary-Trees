Question Link : https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

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
        if(root == null) return null;
        Node cur = root;
        while(cur!=null && cur.left!=null){
            Node n = cur;
            while(true){
                n.left.next = n.right;
                if(n.next==null) break;
                n.right.next = n.next.left;
                n = n.next;
            }
            cur = cur.left;
        }
        return root;
    }
}
