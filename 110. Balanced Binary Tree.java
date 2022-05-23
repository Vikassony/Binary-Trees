Question Link : https://leetcode.com/problems/balanced-binary-tree/

class Solution {
    boolean isBal = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        height(root);
        return isBal;
    }
    
    public int height(TreeNode root){
        if(root == null){
            return -1;
        }
        int l = height(root.left);
        int r = height(root.right);
        if(Math.abs(l-r)>1)
        {
            isBal = false;
            return -1;
        }
        return Math.max(l,r)+1;
    }
}
