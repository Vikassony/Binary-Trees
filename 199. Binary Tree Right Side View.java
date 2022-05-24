Question Link : https://leetcode.com/problems/binary-tree-right-side-view/

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> al = new ArrayList<>();
      if(root==null)
      return al;
      Queue<TreeNode> q = new ArrayDeque<>();
      q.add(root);
      int count = 0;
      while(q.size()>0){
          count = q.size();
          for(int i=0;i<count;i++){
              root = q.remove();
              if(i==0){
                  al.add(root.val);
                  x++;
              }
              if(root.right!=null)
              q.add(root.right);
              if(root.left!=null)
              q.add(root.left);
          }
      }
      return al;
    }
}
