class Node
{
	int key;
	Node child[];

	public Node(int key)
	{
		this.key = key;
		child = new Node[3];
		child[0]=child[1] = null;
	}
}
public class TernaryTreeToList
{
	public static Node convertToList(Node root, Node newHead)
	{
		if(root == null)
			return newHead;
		for(int i = 2; i>=0; i--)
			newHead = convertToList(root.child[i],newHead);

		newHead = addBegin(root,newHead);
		root.child[2] = null;
		return newHead;
	}
	
	public static Node addBegin(Node n,Node head)
	{
		if(head == null)
			return n;

		head.child[0] = n;
		n.child[1] = head;
		n.child[0] = null;

		return n;
	}



	public static void main(String args[])
	{
		Node root = new Node(30);
		root.child[0] = new Node(5);
		root.child[1] = new Node(11);
		root.child[2] = new Node(63);

		root.child[0].child[0] = new Node(1);
		root.child[0].child[1] = new Node(2);
		root.child[0].child[2] = new Node(3);

		root = convertToList(root,null);
		Node ptr = root;

		while(ptr != null){
			System.out.println(ptr.key);
			ptr = ptr.child[1];
		}
	}
}
