Question Link : https://leetcode.com/problems/path-sum-ii/
T.C : O(n)
S.C : O(1)
class Solution {
    List<List<Integer>> al;
    ArrayList<Integer> smallAns;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        al =  new ArrayList<>();
        if(root==null) return al;
        smallAns = new ArrayList<>();
       pathSumD(root, targetSum);
        return al;    
    }
    void pathSumD(TreeNode root, int targetSum){
     if(root == null) return;
        if(root.left == null && root.right == null){
            if(targetSum - root.val == 0){
                ArrayList<Integer> base = new ArrayList<>(smallAns);
                base.add(root.val);
                al.add(base);
            }
        }
        smallAns.add(root.val);
        pathSumD(root.left,targetSum-root.val);
        pathSumD(root.right,targetSum-root.val);
        smallAns.remove(smallAns.size()-1);
    }
}

Brute Force : 
// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {
//     ArrayList<TreeNode> al = new ArrayList<>();
//     ArrayList<Integer> al2;
//     int sum = 0;
//     public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//         getLeaf(root);
//         List<List<Integer>> al1 = new ArrayList<>();
//         for(int i=0;i<al.size();i++){
//             sum = 0;
//             al2 = new ArrayList<>();
//             find(root,al.get(i));
//             if(sum == targetSum){
//                 find1(root,al.get(i));
//                 Collections.reverse(al2);
//                 al1.add(al2);
//             }
//         }
//         return al1;
//     }
//     void getLeaf(TreeNode root){
//         if(root == null)
//             return ;
//         if(root.left == null && root.right == null){
//             al.add(root);
//             return ;
//         }
//         getLeaf(root.left);
//         getLeaf(root.right);
//     }
//     boolean find(TreeNode root,TreeNode tar){
//         if(root == null)
//             return false;
//         if(root==tar){
//             sum += tar.val;
//             return true;
//         }
//         boolean l = find(root.left,tar);
//         if(l){
//             sum += root.val;
//             return true;
//         }
//         boolean r = find(root.right,tar);
//         if(r){
//             sum += root.val;
//             return true;
//         }
//         return false;
//     }
//     boolean find1(TreeNode root,TreeNode tar){
//         if(root == null)
//             return false;
//         if(root==tar){
//             al2.add(root.val);
//             return true;
//         }
//         boolean l = find1(root.left,tar);
//         if(l){
//             al2.add(root.val);
//             return true;
//         }
//         boolean r = find1(root.right,tar);
//         if(r){
//             al2.add(root.val);
//             return true;
//         }
//         return false;
//     }
// }
