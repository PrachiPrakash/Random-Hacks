public class MatrixChain
{
	public static int recursiveSolution(int p[], int i, int j)
	{
		if(i == j)
			return 0;
		else if(i+1 == j)
			return p[i-1]*p[i]*p[j];

		int m = Integer.MAX_VALUE;

		for(int k = i; k<j; k++){
			int cost = recursiveSolution(p,i,k)+recursiveSolution(p,k+1,j)+p[i-1]*p[k]*p[j];
			 m = Math.min(cost,m);
		}

		return m;
	}

	public static int iterativeSolution(int p[])
	{
		int mem[][] = new int[p.length][p.length];
		int n = p.length-1;
		for(int l = 2; l<=p.length-1; l++){

			for(int i=1; i<=n-l+1;i++){
				int j = i+l-1;
				mem[i][j] = Integer.MAX_VALUE;

				for(int k = i; k<=j-1; k++){
					int c = mem[i][k]+mem[k+1][j]+p[i-1]*p[k]*p[j];
					mem[i][j] = Math.min(mem[i][j], c);
				}
			}
		}

		return mem[1][p.length-1];
	}

	public static void main(String args[])
	{
		int p[] = {30,35,15,5,10, 20 ,25};
		System.out.println(recursiveSolution(p,1,p.length - 1));
		System.out.println(iterativeSolution(p));
	}
}