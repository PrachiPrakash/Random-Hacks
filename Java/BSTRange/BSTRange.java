class TreeNode
{
	int key;
	TreeNode left,right;
	public TreeNode(int key)
	{
		this.key = key;
	}
}
public class BSTRange
{
	public static TreeNode insert(TreeNode root, int val)
	{
		if(root == null)
			return new TreeNode(val);

		TreeNode ptr = root;
		TreeNode prev = null;

		while(ptr != null){

			prev = ptr;
			if(ptr.key < val)
				ptr = ptr.right;
			else
				ptr = ptr.left;
		}

		if(prev.key < val)
			prev.right = new TreeNode(val);
		else
			prev.left = new TreeNode(val);

		return root;

	}
	public static void printRange(TreeNode root, int lb, int ub)
	{
		if(root != null){
			if(root.key >= lb && root.key <= ub){
				System.out.println(root.key);
				printRange(root.left, lb, ub);
				printRange(root.right,lb, ub);
			}
			else if(root.key < lb)
				printRange(root.right,lb,ub);
			else if(root.key > ub)
				printRange(root.left, lb, ub);
		}
	}
	public static void main(String args[])
	{
		TreeNode root = insert(null,20);
		root = insert(root,8);
		root = insert(root,4);
		root = insert(root,12);
		root = insert(root,22);
		printRange(root,10, 22);

	}
}
