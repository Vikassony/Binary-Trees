Question Link : https://leetcode.com/problems/maximum-binary-tree/

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0) return null;
        return construct(nums,0,nums.length-1);
    }
    TreeNode construct(int nums[], int lo , int hi){
        if(lo>hi) return null;
        int maxIdx = lo;
        for(int i=lo+1;i<=hi;i++){
            if(nums[i]>nums[maxIdx])
                maxIdx = i;
        }
        TreeNode root = new TreeNode(nums[maxIdx],null,null);
        root.left = construct(nums,lo,maxIdx-1);
        root.right = construct(nums,maxIdx+1,hi);
        return root;
    }
}
