Question Link : https://leetcode.com/problems/path-sum-iii/

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
     int ans = 0;
    public int pathSum(TreeNode root, int k) {
        if(root == null) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        helper(root, k, map, 0);
        return ans;
    }
    
    int helper(TreeNode node, int k, HashMap<Integer, Integer> map, int sum){
        if(node==null) return 0;
        sum += node.val;
    
        if(map.containsKey(sum - k)) ans += map.get(sum - k);
        
        map.put(sum,map.getOrDefault(sum,0)+1);
        
         helper(node.left,k,map,sum);
        
         helper(node.right,k,map,sum);
        
        map.put(sum, map.get(sum) - 1);
        return 0;
    }
}
