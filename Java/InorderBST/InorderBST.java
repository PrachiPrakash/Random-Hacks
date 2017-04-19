class Node
{
	int key;
	Node left, right;

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

	public static Tree constructFromPreorder(int series[])
	{
		Tree ob = new Tree();
		ob.root = constructFromPreorder(ob.root,series,0);
		return ob;
	}

	public static Node constructFromPreorder(Node r, int s[], int ind)
	{
		if(ind == s.length)
			return null;
		if(r == null)
			r = new Node(s[ind]);
		else if(s[ind] < )
	}
}