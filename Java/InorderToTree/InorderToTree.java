import java.util.*;

class Node
{
	int key;
	Node left,right;

	public Node(int key)
	{
		this.key = key;
		left = right = null;
	}

}

public class InorderToTree
{
	public static Node createTree(int pre[])
	{
		Node root = new Node(pre[0]);
		Node ptr = null;
		Stack<Node> context = new Stack<Node>();
		context.push(root);

		for(int i = 1; i<pre.length; i++){
			ptr = null;
			while(!context.isEmpty() && (pre[i] > context.peek().key))
				ptr = context.pop();
			if(ptr == null){
				context.peek().left = new Node(pre[i]);
				context.push(context.peek().left);
			}
			else{
				ptr.right = new Node(pre[i]);
				context.push(ptr.right);
			}
		}

		return root;
	}

	public static void inorder(Node root)
	{
		if(root != null){
			inorder(root.left);
			System.out.println(root.key);
			inorder(root.right);
		}
	}
	public static void main(String args[])
	{
		int pre[] = {1,2,3,4,5};
		Node root = createTree(pre);
	//	System.out.println(root.left.key);
		inorder(root);
	}
}
