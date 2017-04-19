class Node
{
	int val;
	Node left,right;
	public Node(int val)
	{
		this.val = val;
		left = right = null;
	}
}

public class LargeSubtree
{
	public static Node getLargeSubtree(Node root)
	{
		if(root == null)
			return null;
		Node l = getLargeSubtree();
	}
	public static void main(String args[])
	{
		
	}
}
