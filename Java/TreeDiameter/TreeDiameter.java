class TreeNode
{
	int key;
	TreeNode left,right;
	public TreeNode(int key)
	{
		this.key = key;
	}
}
class Tree
{
	TreeNode root;
	int diameter;

	public Tree()
	{
		root = null;
	}

	public int getDiameter()
	{
		diameter = 0;
		getDiameter(root);
		return diameter;
	}

	public int getDiameter(TreeNode root)
	{
		if(root == null)
			return 0;

		int l = getDiameter(root.left);
		int r = getDiameter(root.right);

		int res = 1+l+r;
		int m = Math.max(1+l,1+r);

		diameter = Math.max(diameter,res);
		return m;
	}
}
public class TreeDiameter
{

	public static void main(String args[])
	{
		Tree ob = new Tree();
		ob.root = new TreeNode(1);
		ob.root.left        = new TreeNode(2);
  		ob.root.right       = new TreeNode(3);
  		ob.root.left.left  = new TreeNode(4);
  		ob.root.left.right = new TreeNode(5);

  		System.out.println(ob.getDiameter());
	}
}