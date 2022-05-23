Question Link : https://leetcode.com/problems/diameter-of-binary-tree/
class Solution {
//     public int height(TreeNode node){
//         if(node == null){
//             return -1;
//         }
//         int l = height(node.left);
//         int r = height(node.right);
//         return Math.max(l,r)+1;
//     }
//     public int diameterOfBinaryTree(TreeNode root) {
//         if(root == null){
//             return 0;
//         }
//         int ld = diameterOfBinaryTree(root.left);
//         int rd = diameterOfBinaryTree(root.right);
//         int dvr = height(root.left) + height(root.right) + 2;
        
//         return Math.max(ld,Math.max(rd,dvr));
//     }
    class DiaPair{
        int ht;
        int dia;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        DiaPair m =diameter(root);
        return m.dia;
        
    }
    public DiaPair diameter(TreeNode root){
        if(root == null){
            DiaPair p = new DiaPair();
            p.ht = -1;
            p.dia = 0;
            return p;
        }
        DiaPair l = diameter(root.left);
        DiaPair r = diameter(root.right);
        
        DiaPair m = new DiaPair();
        m.ht = Math.max(l.ht , r.ht) + 1;
        
        int es = l.ht + r.ht + 2;
        
       m.dia = Math.max(es,Math.max(l.dia, r.dia));
        return m ;
    }
}
