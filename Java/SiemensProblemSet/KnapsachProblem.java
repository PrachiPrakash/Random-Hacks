public class KnapsachProblem
{
	public static int getMaxCost(int pi[], int wi[], int c, int i)
	{
		if(c == 0 || i== pi.length)
			return 0;
		
		else if(c-wi[i] >=0)
			return Math.max(pi[i]+getMaxCost(pi, wi, c-wi[i],i+1),getMaxCost(pi, wi, c, i+1));
		else
			return getMaxCost(pi,wi,c,i+1);
	}

	public static void main(String args[])
	{
		int pi[] = {60,100,120};
		int wi[] = {10,20,30};
		System.out.println(getMaxCost(pi,wi,50,0));
		//System.out.println(iterativeSolution(pi,wi,105));
	}

	public static int iterativeSolution(int pi[],int wi[], int c)
	{
		int capacity[] = new int[c+1];
		capacity[0] = 0;

		boolean consider[] = new boolean[pi.length];

		for(int i = 1; i<=c; i++)
		{
			int max =0;
			int m = 0;

			for(int j=0; j<pi.length; j++){
				if(i-wi[j] >= 0)
					m = pi[j]+capacity[i-wi[j]];
				if(m > max)
					max = m;	
			}
			capacity[i] =  max;
		}

		return capacity[c];
	}
}