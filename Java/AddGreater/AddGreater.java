class TreeNode
{
	int key;
	TreeNode left,right;
	public TreeNode(int key)
	{
		this.key = key;
	}
}

public class AddGreater
{
	int sum;
	public void addGreater(TreeNode root)
	{
		sum = 0;
		addGreaterUtil(root);
	}

	public void addGreaterUtil(TreeNode root)
	{
		if(root != null){
			addGreaterUtil(root.right);
			root.key += sum;
			sum = root.key;
			addGreaterUtil(root.left);
		}
	}

	public  TreeNode insert(TreeNode root, int val)
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
		AddGreater ob = new AddGreater();
		TreeNode root = ob.insert(null, 50);
    	ob.insert(root, 30);
    	ob.insert(root, 20);
    	ob.insert(root, 40);
    	ob.insert(root, 70);
    	ob.insert(root, 60);
    	ob.insert(root, 80);

    	ob.addGreater(root);
    	ob.inorder(root);
	}
}
