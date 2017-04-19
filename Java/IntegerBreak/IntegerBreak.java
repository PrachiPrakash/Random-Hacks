public class IntegerBreak
{

	public static int getMaxBreakProduct(int n)
	{
		if(n == 1)
			return 0;
		if(n == 2)
			return 1;
		int max = 0;
		for(int i = n-1; i>=1; i--){
			int p = Math.max(i*getMaxBreakProduct(n-i),i*(n-i));
			if(p > max)
				max = p;
		}

		return max;

	}

	public static int getMaxBreak(int n)
	{
		if(n == 1)
			return 0;
		if(n == 2)
			return 1;

		int mem[] = new int[n+1];
		mem[0] = mem[1] = 0;
		mem[2] = 1;

		for(int i = 3; i<=n; i++){
			int max = 0;
			for(int j = i-1; j>=2; j--){
				int p = Math.max(j*mem[i-j],j*(i-j));
				if(p > max)
					max = p;
			}
			mem[i] = max;
		}
		return mem[n];

	}

	public static void main(String args[])
	{
		System.out.println(getMaxBreak(5));
	}

}