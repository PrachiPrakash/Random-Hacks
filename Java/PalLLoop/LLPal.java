import java.util.*;

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

public class LLPal
{
		public static boolean getStartNode(Node head)
		{
			Node slow = head;
			Node fast = head;

			do{
				fast = fast.next.next;
				slow = slow.next;

			}while(slow != fast);

			slow = head;

			do{
				slow = slow.next;
				fast = fast.next;
			}while(slow != fast);

			Node start = slow;
			slow = start;

			//end is saved in slow
			while(slow.next != fast)
				slow = slow.next;

			//points to head
			fast = head;

			Stack<Integer> stk = new Stack<Integer>();
			while(fast != slow){
				stk.push(fast.key);
				fast = fast.next;
			}

			stk.push(slow.key);
			fast = head;

			while(fast != slow){
				if(fast.key == stk.peek())
					stk.pop();
				else
					return false;
				fast = fast.next;
			}

			if(slow.key == stk.peek())
				return true;
			else
				return false;


		}

		public static void main(String ...args)
		{
			Node head = new Node(1);
			head.next = new Node(2);
			head.next.next = new Node(3);

			head.next.next.next = new Node(2);
			head.next.next.next.next = new Node(1);
			head.next.next.next.next.next = head.next.next.next;

			System.out.println(getStartNode(head));

		}
}