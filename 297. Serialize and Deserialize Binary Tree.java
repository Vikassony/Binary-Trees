Question Link : https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        serl(root,sb);
        return sb.toString();
    }
    public void serl(TreeNode root, StringBuilder sb){ // PreOrder traversal
        if(root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val+",");
        serl(root.left,sb);
        serl(root.right,sb);
    }
    // Decodes your encoded data to tree.
    static class Pair{
        TreeNode node;
        int state;
        Pair(TreeNode node, int state){
            this.node = node;
            this.state = state;
        }
    }
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        String a[] = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(a[0]));
		Pair rp = new Pair(root,1);
		Stack<Pair> st = new Stack<>();
		st.push(rp);
		int idx = 0;
		while(st.size()>0){
		    Pair top = st.peek();
		    if(top.state == 1){
		        idx++;
		        if(a[idx].equals("null")==false){
		            top.node.left = new TreeNode(Integer.parseInt(a[idx]));
		            Pair lp = new Pair(top.node.left,1);
		            st.push(lp);
		        }else{
		            top.node.left = null;
		        }
		        top.state++;
		    }else if(top.state == 2){
		        idx++;
		        if(a[idx].equals("null")==false){
		            top.node.right = new TreeNode(Integer.parseInt(a[idx]));
		            Pair rtp = new Pair(top.node.right,1);
		            st.push(rtp);
		        }else{
		            top.node.right = null;
		        }
		        top.state++;
		    }else{
		        st.pop();
		    }
		}
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
