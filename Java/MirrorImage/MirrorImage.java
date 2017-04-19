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

public class MirrorImage
{
	public static boolean checkMirror(Node root1, Node root2)
	{
		Stack<Node> t1 = new Stack<Node>();
		Stack<Node> t2 = new Stack<Node>();

		Node r1 = null, r2 = null;
		Node c1 = null, c2 = null;

		r1 = root1;
		r2 = root2;

		while(r1 != null){
			t1.push(r1);
			r1 = r1.left;
		}

		while(r2 != null){
			t2.push(r2);
			r2  = r2.right;
		}

		while(!t1.isEmpty() && !t2.isEmpty()){
			c1 = t1.pop();
			c2 = t2.pop();

			if(c1.key != c2.key)
				return false;

			if(c1.right != null){
				c1 = c1.right;
				while(c1 != null){
					t1.push(c1);
					c1 = c1.left;
				}
			}

			if(c2.left != null){
				c2 = c2.left;
				while(c2 != null){
					t2.push(c2);
					c2 = c2.right;
				}
			}
		}

		if(t1.isEmpty() && t2.isEmpty())
			return true;
		else
			return false;
	}
	public static void main(String args[])
	{
		Node root1 = new Node(1);
		Node root2 = new Node(1);

		root1.left = new Node(2);
		root1.right = new  Node(3);
		root1.right.left = new Node(4);

		root2.left = new Node(3);
		root2.left.right = new Node(4);
		//root2.right = new Node(2);

		System.out.println(checkMirror(root1,root2));
	}
}
