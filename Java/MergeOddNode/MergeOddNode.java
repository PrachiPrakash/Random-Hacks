class Node
{
	int val;
	Node left,right;
	public Node(int val)
	{
		this.val = val;
	}
}

public class MergeOddNode
{
	public static void mergeOdd(Node root)
	{
		if(root != null){
			mergeOdd(root.left);
			mergeOdd(root.right);

			if(root.val  %2 != 0){
				if(root.left != null && root.left.val %2==0){
					int temp = root.left.val;
					root.left.val = root.val;
					root.val = temp;
				}
				else if(root.right != null && root.right.val %2==0){
					int temp = root.right.val;
					root.right.val = root.val;
					root.val = temp;
				}
			}
		}
	}

	public static void inorder(Node root)
	{
		if(root != null){
			inorder(root.left);
			System.out.println(root.val);
			inorder(root.right);
		}
	}

	public static void main(String args[])
	{
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		mergeOdd(root);
		inorder(root);
	}
}
