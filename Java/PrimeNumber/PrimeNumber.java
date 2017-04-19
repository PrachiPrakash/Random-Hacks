public class PrimeNumber
{
	public static boolean arr[] = new boolean[1000001];
	public static long prefix[][] = new long[10][1000001];

	public static void init()
	{
		//sieve Algorithm
		arr[2] = false;
		for(int j =3; j<=1000000; j++){
			if(arr[j] == false){
				int k = 2;
				countDigit(j);
				while(k*j <= 1000000){
					arr[k*j] = true;
					k++;
				}
			}
		}

		//construct prefix
		for(int i=0; i<=9; i++){
			for(int j=1; j<=1000000; j++)
				prefix[i][j] += prefix[i][j-1];
		}
	}

	static void countDigit(int j)
	{
		int k = j;
		while(k > 0){
			prefix[k%10][j]++;
			k = k/10;
		}
	}

	static void printPrimeInRange(int l, int r)
	{
		for(int i=l; i<=r; i++){
			if(!arr[i])
				System.out.println(i);
		}
	}
	static void printMaxDigit(int l, int r)
	{
		long m = prefix[0][r]-prefix[0][l-1];

		for(int i = 1; i<=9; i++){
			if(prefix[i][r]-prefix[i][l-1] > m)
				m = prefix[i][r]-prefix[i][l-1];
		}

		System.out.println(m);
	}
	public static void main(String args[])
	{
		init();
		printPrimeInRange(21,40);
		printMaxDigit(21,40);
	}
}