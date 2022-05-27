Question Link : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

class Solution {
     int preIndex = 0;
     HashMap<Integer,Integer> hm = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;    
        for(int i=0;i<n;i++){
            hm.put(inorder[i],i);
        }
        return construct(inorder,preorder,0,n-1);
    }
     TreeNode construct(int inorder[], int preorder[], int si, int ei){
        if(si>ei)
        return null;
        TreeNode node = new TreeNode(preorder[preIndex++]);
        if(si==ei)
        return node;
        int inIndex = hm.get(node.val);
        node.left = construct(inorder,preorder,si,inIndex-1);
        node.right = construct(inorder,preorder,inIndex+1,ei);
        return node;
    }
}
