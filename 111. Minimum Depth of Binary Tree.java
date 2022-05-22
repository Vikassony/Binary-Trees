Qestion Link : https://leetcode.com/problems/minimum-depth-of-binary-tree/
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        if(l==0 || r==0){
            return 1+Math.max(l,r);
        }
        return Math.min(l,r)+1;
    }
}
