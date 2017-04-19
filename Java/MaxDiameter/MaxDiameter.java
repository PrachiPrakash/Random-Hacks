public class MaxDiameter
{
	static int diameter;
	static int getDiameter(int nodes, int tree[])
	{
		if(nodes == 0)
			return 0;
		else if(nodes == 1)
			return tree[0];

		diameter = Integer.MIN_VALUE;
		getDiameter(nodes,tree,0);
		return diameter;
	}

	static int getDiameter(int n, int tree[], int i)
	{
		if(i >= n)
			return 0;
		int lsum = getDiameter(n,tree,2*i+1);
		int rsum = getDiameter(n,tree,2*i+2);

		int l = tree[i]+Math.max(lsum, rsum);

		//int m = Math.max(l,lsum+rsum+tree[i]);
		diameter = Math.max(diameter,tree[i]+lsum+rsum);


		return l;
	}

	public static void main(String args[])
	{
		int tree[] = {2,4,5,8,-4,3,-6};
		System.out.println(getDiameter(7,tree));
	}
}