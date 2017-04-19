class TreeNode
{
	int key;
	TreeNode left,right;

	public TreeNode(int key)
	{
		this.key = key;
	}

}

public class SumTree
{
	public int sumTree(TreeNode root)
	{
		if(root == null)
			return 0;
		if(root.left == null && root.right == null){
			int temp = root.key;
			root.key = 0;
			return temp;
		}
		else{
			int left = sumTree(root.left);
			int right = sumTree(root.right);
			int temp = root.key;
			root.key = left+right;

			if(root.left != null)
				root.key += root.left.key;
			if(root.right != null)
				root.key += root.right.key;
			return temp;
		}
	}
	public void inorder(TreeNode root)
	{
		if(root != null){
			inorder(root.left);
			System.out.println(root.key);
			inorder(root.right);
		}
	}
	public static void main(String args[])
	{
		SumTree ob = new SumTree();
		TreeNode root = new TreeNode(10);
  		root.left = new TreeNode(-2);
  		root.right = new TreeNode(6);
  		root.left.left = new TreeNode(8);
  		root.left.right = new TreeNode(-4);
  		root.right.left = new TreeNode(7);
  		root.right.right = new TreeNode(5);

  		ob.sumTree(root);

  		ob.inorder(root);
	}
}