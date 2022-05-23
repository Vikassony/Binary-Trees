Question Link : https://leetcode.com/problems/average-of-levels-in-binary-tree/

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> al = new ArrayList<>();
        if(root==null){
            return al;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(q.size()>0){
            int size = q.size();
            double sum = 0.0;
            for(int i=0;i<size;i++){
                root = q.remove();
                sum += root.val;
                if(root.left!=null)
                    q.add(root.left);
                if(root.right!=null)
                    q.add(root.right);
            }
            al.add(sum/size);
        }
        return al;
    }
}
