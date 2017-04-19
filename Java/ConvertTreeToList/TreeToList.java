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
class Tree
{
	Node root;
	public Tree()
	{
		root = null;
	}

	public static Node insertAtBegining(Node root,Node n)
	{
		if(root == null)
			return n;
		n.right = root;
		n.left = null;
		root.left = n;
		root = n;

		return n;
	}

	public void treeToList()
	{
		Node newl = null;
		newl = helper(newl,root);
		root = newl;

	}

	private Node helper(Node newl, Node root)
	{
		if(root != null){
			newl = helper(newl, root.right);
			Node t = root.left;
			newl = insertAtBegining(newl,root);
			newl = helper(newl,t);
			return newl;

		}

		else
			return newl;

	}

	public void printList()
	{
		Node ptr = root;

		while(ptr != null){
			System.out.println(ptr.key);
			ptr = ptr.right;
		}
	}
	
}

public class TreeToList
{
	public static void main(String args[])
	{
		Tree one = new Tree();
		one.root = new Node(6);
		one.root.left = new Node(4);
		one.root.left.right = new Node(5);
		one.root.right = new Node(10);

		one.treeToList();
		one.printList();
	}
}
