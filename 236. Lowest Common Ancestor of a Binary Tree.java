Question Link :  https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    ArrayList<TreeNode> al3;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        al3 = new ArrayList<>();
        find(root,p);
        ArrayList<TreeNode> al1 = new ArrayList<>();
        for(TreeNode t : al3)
            al1.add(t);
        al3 = new ArrayList<>();
        find(root,q);
        ArrayList<TreeNode> al2 = new ArrayList<>();
        for(TreeNode t : al3)
            al2.add(t);
        int i = al1.size() - 1;
        int j = al2.size() - 1;
        while(i>=0 && j>=0 && al1.get(i)==al2.get(j)){
            i--;
            j--;
        }
        i++;
        j++;
        return al2.get(j)!=null?al2.get(j):al1.get(i);
    }
    boolean find(TreeNode root, TreeNode t){
        if(root == null) return false;
        if(root == t){
            al3.add(root);
            return true;
        }
        boolean l = find(root.left,t);
        if(l){
            al3.add(root);
            return true;
        }
        boolean r = find(root.right,t);
        if(r){
            al3.add(root);
            return true;
        }
        return false;
    }
}
