import java.util.*;
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

public class TreeToSprialList
{
	public static Node spiralList(Node root)
	{
		Deque<Node> qu = new ArrayDeque<Node>();
		qu.push(root);
		int count = 1;
		int choice = 1;
		int currCount =0;

		Node ptr = null;
		Node head = root;
		Node currList = null;

		while(!qu.isEmpty()){
			currCount = 0;

			for(int i = 1; i<=count; i++){
				if(choice % 2 == 0)
					ptr = qu.pollFirst();
				else
					ptr = qu.pollLast();
				if(ptr.left != null){
					qu.add(ptr.left);
					currCount++;
				}
				if(ptr.right != null){
					qu.add(ptr.right);
					currCount++;
				}

				if(currList == null){
					ptr.left = null;
					currList = ptr;
				}
				else{
					currList.right = ptr;
					ptr.left = currList;
					currList = currList.right;
				}
				

				
			}
			count = currCount;
			choice = (choice + 1)%2;
		}
		currList.right = null;
		return head;
	}
	public static void main(String args[])
	{
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);

		root = spiralList(root);

		Node ptr = root;

		while(ptr != null){
			System.out.println(ptr.key);
			ptr = ptr.right;
		}
	}
}
