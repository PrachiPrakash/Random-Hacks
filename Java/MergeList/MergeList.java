class Node
{
	int key;
	Node next;
	public Node(int key)
	{
		this.key = key;
		next = null;
	}
}

public class MergeList
{
	public static Node mergeList(Node h1, Node h2)
	{
		Node newHead = null;
		Node ptr = null;
		Node curr = null;

		if(h1.key < h2.key){
			newHead = h1;
			h1 = h1.next;
		}
		else{
			newHead = h2;
			h2 = h2.next;
		}

		ptr = newHead;

		while(h1 != null && h2 != null){

			if(h1.key < h2.key){
				curr = h1;
				h1 = h1.next;
			}
			else{
				curr = h2;
				h2 = h2.next;
			}
			ptr.next = curr;
			ptr = ptr.next;
		}
		if(h1 != null)
			ptr.next = h1;
		if(h2 != null)
			ptr.next = h2;
		return newHead;
	}

	public static Node mergeKList(Node klist[])
	{
		int l = klist.length - 1;
		int i = 0 , j = 0;
		while(l != 0){
			i = 0; j = l;
			while(i < j){
				klist[i] = mergeList(klist[i], klist[j]);
				i++;j--;
			}
			l = j;
		}
		return klist[0];
	}
	public static void main(String ...args)
	{
		Node klist[] = new Node[3];

		klist[0] = new Node(1);
		klist[0].next = new Node(2);

		klist[1] = new Node(3);
		klist[1].next = new Node(4);

		klist[2] = new Node(5);
		klist[2].next = new Node(6);

		Node m = mergeKList(klist);

		Node ptr = m;
		while(ptr != null){
			System.out.println(ptr.key);
			ptr = ptr.next;
		}
	}

}
