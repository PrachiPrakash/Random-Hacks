public class SortedMedian
{

	public static int getMedian(int a[], int b[],int s1, int s2,int n)
	{
		if(n <= 0)
			return -1;
		else if(n == 1)
			return (a[s1] + b[s2])/2;
		else if (n == 2)
			return (max(a[s1],b[s2])+min(a[s1+1], b[s2+1]))/2;

		int m1 = median(a,s1,n);
		int m2 = median(b,s2,n);

		if(m1 == m2)
			return m1;
		else if(m1 < m2){
			if(n % 2 == 0)
				return getMedian(a, b, n-n/2-1,s2,n-n/2+1);
			else
				return getMedian(a,b, n-n/2-1,s1,n-n/2);
		}
		if(n %2 == 0)
			return getMedian(a, b, s1, n-n/2-1, n-n/2+1);
		return getMedian(a,b, s1,n-n/2-1,n-n/2);

	}

	public static int median(int a[],int s, int n)
	{
		if(n % 2 == 0)
			return (a[n-n/2+s]+a[n-n/2+s-1])/2;
		else
			return a[n-n/2+s];
	}

	public static int max(int a, int b)
	{
		if(a > b)
			return a;
		else
			return b;
	}
	public static int min(int a, int b)
	{
		if(a < b)
			return a;
		else
			return b;
	}

	public static void main(String args[])
	{
		int a[] = {1,2,3,4};
		int b[] = {5,6,7,8};
		System.out.println(getMedian(a,b,0,0,4));
	}
}
