Question Link : https://leetcode.com/problems/subtree-of-another-tree/

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null) return false;
        if(subRoot==null) return true;
        if(isSame(root,subRoot))
            return true;
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    boolean isSame(TreeNode p, TreeNode q){
        if(p==null || q==null){
            return p==q;
        }
        return (p.val==q.val) && (isSame(p.left,q.left)) && (isSame(p.right,q.right));
    }
}
