class Node
{
	int val;
	Node prev,next;
	public Node(int val)
	{
		this.val = val;
	}
}
public class DLLToTree
{
	public static Node node;
	public static Node insert(Node head, int key)
	{
		if(head == null)
			return new Node(key);
		
		Node nw = new Node(key);
		nw.next = head;
		head.prev = nw;

		return nw;

	}

	public static int getLength(Node head)
	{
		int c = 0;
		while(head != null){
			c ++;
			head = head.next;
		}

		return c;
	}

	public static Node constructTree(Node head)
	{
		node = head;
		head = constructTree(getLength(head));
		node = null;
		return head;
	}

	public static Node constructTree(int n)
	{
		if(n <= 0)
			return null;
		Node l = constructTree(n/2);
		node.prev = l;
		Node ptr = node;
		node = node.next;

		Node r = constructTree(n - n/2 -1);

		ptr.next = r;

		return ptr;
	}

	public static void inorder(Node r)
	{
		if(r == null){
			System.out.print("0 ");
			return;
		}
		inorder(r.prev);
		System.out.print(r.val+" ");
		inorder(r.next);
	}
	public static void main(String args[])
	{
		Node head = insert(null,10);
		 head = insert(head, 9);
		 head = insert(head,8);
		 head = insert(head,7);
		 head = insert(head,6);
		 head = insert(head,5);
		 head = insert(head,4);
		 head = insert(head,3);
		 head = insert(head,2);
		 head = insert(head,1);

		 head = constructTree(head);
		 inorder(head);
		 System.out.println();
	}
}