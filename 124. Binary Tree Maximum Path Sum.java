Question Link : https://leetcode.com/problems/binary-tree-maximum-path-sum/

class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        maxP(root);
        return ans;
    }
    int maxP(TreeNode root){
        if(root == null) return 0;
        int l = maxP(root.left);
        int r = maxP(root.right);
        int sp = Math.max(root.val,Math.max(l+root.val,r+root.val));
        int cp = l+r+root.val;
        ans = Math.max(ans,Math.max(sp,cp));
        return sp;
    }
}
