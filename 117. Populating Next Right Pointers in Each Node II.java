Question Link : https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Node head = root;
        while(head!=null){
            Node dummy = new Node(-1);
            Node temp = dummy;
            while(head!=null){
                if(head.left!=null){
                    temp.next = head.left;
                    temp = temp.next;
                }
                if(head.right!=null){
                    temp.next = head.right;
                    temp = temp.next;
                }
                head = head.next;r
            }
            head = dummy.next;
        }
        return root;
    }
}
