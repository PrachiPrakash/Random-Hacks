class TreeNode
{
	int key;
	TreeNode left,right;
	public TreeNode(int key)
	{
		this.key = key;
	}
}

public class GreatestBST
{
	private int gMin;
	private int gMax;
	private boolean isBST;
	private int maxLen;

	public GreatestBST()
	{
		gMin = Integer.MAX_VALUE;
		gMax = Integer.MIN_VALUE;
		isBST = false;
		maxLen = 0;
	}


	
	

	public int maxBST(TreeNode root)
	{
		gMin = Integer.MAX_VALUE;
		gMax = Integer.MIN_VALUE;
		isBST = false;
		maxLen = 0;
		
		maxBSTUtil(root);

		return maxLen; 	
	}

	public int maxBSTUtil(TreeNode root)
	{
		if(root == null){
			isBST = true;
			return 0;
		}

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		boolean isLeft = false;
		boolean isRight = false;

		gMax = Integer.MIN_VALUE;
		int left = maxBSTUtil(root.left);
		

		if(isBST && root.key > gMax)
			isLeft = true;
		min = gMin;

		gMin = Integer.MAX_VALUE;
		int right = maxBSTUtil(root.right);
		
		if(isBST && root.key < gMin)
			isRight = true;
		
		if(min < gMin)
			gMin = min;

		if(root.key < gMin)
			gMin = root.key;

		if(root.key > gMax)
			gMax = root.key; 

		if(isLeft && isRight){
			if(left + right + 1 > maxLen){
				maxLen = left + right + 1;
				
			}
			return left+right+1;

		}
		else{
			isBST = false;
			return 0;
		}
	}

	public static void main(String args[])
	{

		GreatestBST ob = new GreatestBST();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);

		//root.right  = new TreeNode(4);

		System.out.println(ob.maxBST(root));
	}
}