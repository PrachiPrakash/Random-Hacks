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

	public void printLeftBoundary(Node root)
	{
		if(root != null){
			if(root.left != null){
				System.out.println(root.key);
				printLeftBoundary(root.left);
			}
			else if(root.right != null){
				System.out.println(root.key);
				printLeftBoundary(root.right);
			}
		}
	}

	public void printLeaf(Node root)
	{
		if(root != null){

			printLeaf(root.left);
			if(root.left == null && root.right == null)
				System.out.println(root.key);
			printLeaf(root.right);
		}
	}	

	public void printRightBoundary(Node root)
	{
		if(root != null){
			if(root.right != null){
				printRightBoundary(root.right);
				System.out.println(root.key);
			}
			else if(root.left != null){
				printRightBoundary(root.left);
				System.out.println(root.key);
			}

		}
	}

	public void boundaryTraversal()
	{
		if(root != null){
			System.out.println(root.key);
			printLeftBoundary(root.left);
			printLeaf(root.left);
			printLeaf(root.right);
			printRightBoundary(root.right);
		}
	}
}

public class BoundaryTraversal
{
	public static void main(String args[])
	{
		Tree tree = new Tree();
		tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);
        tree.boundaryTraversal();
	}
}