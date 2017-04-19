public class MaxProductTriplet
{
	public static int getMaxProductTriplet(int ar[])
	{
		int len = ar.length - 1;
		int max = Integer.MIN_VALUE;
		int curr_max = Integer.MIN_VALUE;

		for(int i= 0; i<=len-2; i++){
			for(int j = i+1; j<=len-1; j++){
				int p = ar[i]*ar[j]*ar[j+1];
				if(p > curr_max)
					curr_max = p;
			}
			if(curr_max > max)
				max = curr_max;
		}

		return max;

	}
	public static void main(String args[])
	{
		int a[] = {10, 3, 5, 6, 20};
		System.out.println(getMaxProductTriplet(a));
	}
}
