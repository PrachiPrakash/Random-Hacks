public class EquationPermutation
{
	public static int getWays(int n)
	{
		int dp[][] = new int[n+1][4];
		for(int i=1; i<=n; i++)
			dp[i][0] = 1;

		for(int i=1; i<=n; i++){
			for(int j=1; j<=3; j++){
				if(i-(j+1) >= 0)
					dp[i][j] += dp[i-(j+1)][j];
				dp[i][j] += dp[i-1][j-1]; 
			}
		}
		return dp[n][3];
	}
	public static void main(String args[])
	{
		System.out.println(getWays(8));
	}
}