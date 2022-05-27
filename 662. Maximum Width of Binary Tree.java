 Question Link : https://leetcode.com/problems/maximum-width-of-binary-tree/

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
    static class Pair{
        TreeNode node;
        int idx;
        Pair(TreeNode node, int idx){
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root,0));
        int max = 0;
        while(q.size()>0){
            int size = q.size();
            int l = q.peek().idx;
            int r = q.peek().idx;
            while(size-->0){
                Pair rp = q.remove();
                r = rp.idx;
                if(rp.node.left!=null)
                    q.add(new Pair(rp.node.left,2*rp.idx+1));
                if(rp.node.right!=null)
                    q.add(new Pair(rp.node.right,2*rp.idx+2));
            }
            max = Math.max(max,(r-l)+1);
        }
        return max;
    }
}
