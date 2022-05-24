Question Link :  https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> al1 = new ArrayList<>();
        if(root == null)
            return al1;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(q.size()>0){
            ArrayList<Integer> al = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size;i++){
                root = q.remove();
                al.add(0,root.val);
                if(root.right!=null)
                    q.add(root.right);
                if(root.left!=null)
                    q.add(root.left);
            }
            al1.add(0,al);
        }
        return al1;
    }
}
