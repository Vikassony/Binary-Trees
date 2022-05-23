import java.util.*;
public class Main
{
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static class Pair{
        Node node;
        int state;
        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }
    public static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
	public static void main(String[] args) {
		Integer a[] = {50,25,12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null,null};
		Node root = new Node(a[0],null,null);
		Pair rp = new Pair(root,1);
		Stack<Pair> st = new Stack<>();
		st.push(rp);
		int idx = 0;
		while(st.size()>0){
		    Pair top = st.peek();
		    if(top.state == 1){
		        idx++;
		        if(a[idx]!=null){
		            top.node.left = new Node(a[idx],null,null);
		            Pair lp = new Pair(top.node.left,1);
		            st.push(lp);
		        }else{
		            top.node.left = null;
		        }
		        top.state++;
		    }else if(top.state == 2){
		        idx++;
		        if(a[idx]!=null){
		            top.node.right = new Node(a[idx],null,null);
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
		preOrder(root);
	}
}
