import java.util.*;

class Node
{
	int key;
	Node left, right;
	public Node(int key)
	{
		this.key = key;
	}

}

class Tree
{
	Node root;
	public Tree()
	{
		root = null;
	}
	public void postorder()
	{
		Node r = root;
		Stack<Node> c = new Stack<Node>();
		while(r != null){
			if(r.right != null)
				c.push(r.right);
			c.push(r);
			r = r.left;
		}

		while(!c.isEmpty()){
			Node temp = c.pop();
			if(!c.isEmpty() && temp.right == c.peek()){
				Node t1  = c.pop();
				c.push(temp);
				while(t1 != null){
					if(t1.right != null)
						c.push(t1.right);
					c.push(t1);
					t1 = t1.left;
				}
			}
			else
				System.out.println(temp.key);
		}
	}
}
public class IterativePostOrder
{
	public static void main(String ...args)
	{
		Tree tree = new Tree();
		tree.root = new Node(1);

		tree.root.left = new Node(2);
		tree.root.right = new Node(3);

		tree.root.left.left = new Node(4);
		tree.root.left.left.right = new Node(5);

		tree.postorder();
	}
}