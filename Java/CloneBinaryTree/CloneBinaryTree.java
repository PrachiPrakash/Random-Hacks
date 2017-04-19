import java.util.*;
class Node
{
	int val;
	Node left, right, random;

	public Node(int val)
	{
		this.val = val;
	}
}
public class CloneBinaryTree
{
	public static Node constructNoRandom(Node root, HashMap<Node,Node> h)
	{
		if(root == null)
			return null;
		Node r = new Node(root.val);
		h.put(r,root.random);

		r.left = constructNoRandom(root.left, h);
		r.right = constructNoRandom(root.right,h);

		return r;

	}

	public static void constructComplete(Node root, HashMap<Node, Node> h)
	{
		if(root != null){
			constructComplete(root.left, h);
			root.random = h.get(root);
			constructComplete(root.right, h);
		}
	}

	public static Node cloneBin(Node root)
	{
		HashMap<Node, Node> map = new HashMap<Node, Node>();
		Node r = constructNoRandom(root, map);

		constructComplete(r,map);

		return r;
	}

	public static void print(Node root)
	{
		if(root != null){

			print(root.left);
			System.out.print(root.val +" ");

			if(root.random != null)
				System.out.print(root.random.val+"\n");
			else
				System.out.print("\n");

			print(root.right);
		}
	}
	public static void main(String args[])
	{
		Node tree = new Node(1);
    	tree.left = new Node(2);
    	tree.right = new Node(3);
    	tree.left.left = new Node(4);
    	tree.left.right = new Node(5);
    	tree.random = tree.left.right;
   		 tree.left.left.random = tree;
    	tree.left.right.random = tree.right;

    	Node r = cloneBin(tree);
    	print(r);
	}

}