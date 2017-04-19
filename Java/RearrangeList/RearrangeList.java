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

public class RearrangeList
{
	public static Node getMid(Node head)
	{
		Node slow = head;
		Node fast = head;

		if(head != null)
		{
			while(fast != null && fast.next != null){
				fast = fast.next.next;
				slow = slow.next;
			}

		}

		return slow;
	}

	public static Node reverseList(Node head)
	{
		if(head == null || head.next == null)
			return head;

		Node p = head;
		Node q = head.next;

		while(q != null){
			Node t = q.next;
			q.next = p;
			p = q;
			q = t;
		}
		head.next = null;
		return p;

	}

	public static Node reorderList(Node head)
	{
		Node mid = getMid(head);
		System.out.println("mid over");
		Node newHead = mid.next;
		mid.next = null;

		newHead = reverseList(newHead);
		System.out.println("reverse over");
		
		Node l1 = head;
		Node l2 = newHead;
		Node temp = null;
		int i  = 0;
		System.out.println("here");
		while(l2 != null && l1 != null){
			if(i == 0){
				temp = l1.next;
				l1.next = l2;
				l1 = temp;
				i = (i+1)%2;
			}
			else{
				temp = l2.next;
				l2.next = l1;
				l2 = temp;
				i = (i+1)%2;
			}
		}

		return head;

	}

	public static Node alternateReverse(Node head)
	{
		if(head == null || head.next == null)
			return head;

		Node p = head;
		Node q = head.next;
		Node temp = null;
		head = head.next;

		while(q != null){
			temp = q.next;
			q.next = p;
			q = (temp != null)?temp.next:temp;
			if(q == null && temp != null)
				p.next = temp;
			else
				p.next = q;

			p = temp;
		
		}

		return head;


	}

	public static void main(String args[])
	{
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		//head = reorderList(head);
		head = alternateReverse(head);
		Node ptr = head;

		while(ptr != null){
			System.out.println(ptr.key);
			ptr = ptr.next;
		}


	}
}
