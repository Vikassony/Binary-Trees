Question Link : https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

/**
 * Definition for a binary
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    ArrayList<TreeNode> path;
    List<Integer> res; 
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        path = new ArrayList<TreeNode>();
         res = new ArrayList<>();
        find(root,target.val);
        for(int i=0;i<path.size();i++){
            if(k-i<0)
                break;
            printKLevelsDown(path.get(i),k-i,i==0?null:path.get(i-1));
        }
        return res;
    }
    public boolean find(TreeNode node, int data){
        if(node == null)
            return false;
        if(node.val == data)
        {
            path.add(node);
            return true;
        }
        boolean left = find(node.left, data);
        if(left == true){
            path.add(node);
            return true;
        }
        boolean right = find(node.right,data);
        if(right == true){
            path.add(node);
            return true;
        }
        return false;
    }
    public void printKLevelsDown(TreeNode node, int k, TreeNode breaker){
        if(node == null || k<0 || node == breaker)
            return;
        if(k == 0){
            res.add(node.val);
            return;
        }
        printKLevelsDown(node.left,k-1,breaker);
        printKLevelsDown(node.right,k-1,breaker);
    }
}
