import java.util.*;
class TreeNode
{
	int key;
	TreeNode left, right;
	boolean isThread;

	public TreeNode(int key)
	{
		this.key = key;
	}

}

class Tree
{
	TreeNode root;
	public Tree()
	{
		root = null;
	}

	public void convertToThreaded()
	{
		LinkedList<TreeNode> lis = new LinkedList<TreeNode>();
		getInorderList(root, lis);
		lis.pollFirst();

		constructThreadTree(root, lis);
	}

	private void constructThreadTree(TreeNode root, LinkedList<TreeNode> lis)
	{
		if(root != null){
			constructThreadTree(root.left, lis);
			if(root.right == null){
				root.right = lis.pollFirst();
				root.isThread = true;
			}
			else{
				lis.pollFirst();
				constructThreadTree(root.right,lis);
			}
		}
	}

	private void getInorderList(TreeNode root, List<TreeNode> lis)
	{
		if(root != null){
			getInorderList(root.left,lis);
			lis.add(root);
			getInorderList(root.right,lis);
		}
	}

	public void inorder()
	{
		TreeNode leftMost = getLeftMost(root);

		while(leftMost != null){
			System.out.println(leftMost.key);
			if(leftMost.isThread == true)
				leftMost = leftMost.right;
			else
				leftMost = getLeftMost(leftMost.right);
		}
	}

	private TreeNode getLeftMost(TreeNode root)
	{
		if(root == null)
			return null;
		while(root.left != null)
			root = root.left;
		return root;
	}

}

public class ConvertInthreaded
{
	public static void main(String ...args)
	{
		Tree ob = new Tree();

		ob.root = new TreeNode(1);
		ob.root.left = new TreeNode(2);
		ob.root.right = new TreeNode(3);

		 ob.root.left.left = new TreeNode(4);
        ob.root.left.right = new TreeNode(5);
        ob.root.right.left = new TreeNode(6);
        ob.root.right.right = new TreeNode(7);
        ob.convertToThreaded();
        ob.inorder();
	}
}