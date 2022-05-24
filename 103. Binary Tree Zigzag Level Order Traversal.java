Question Link : https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> al1 = new ArrayList<>();
        if(root == null)
            return al1;
        Stack<TreeNode> ms = new Stack<>();
        Stack<TreeNode> cs = new Stack<>();
        ms.push(root);
        ArrayList<Integer> al = new ArrayList<>();
        boolean lvl = true;
        while(ms.size()>0){
            root = ms.pop();
            al.add(root.val);
            if(lvl){
                if(root.left!=null)
                    cs.push(root.left);
                if(root.right!=null)
                    cs.push(root.right);
            }else{
                if(root.right!=null)
                    cs.push(root.right);
                if(root.left!=null)
                    cs.push(root.left);
            }
            if(ms.size()==0){
                al1.add(al);
                al = new ArrayList<>();
                ms = cs;
                cs = new Stack<>();
                lvl = !lvl;
            }
        }
        
        return al1;
    }
}
