import java.util.*;
public class PrimeGenerator
{
	private static final int MAX = 100000000;
	private static byte notPrime[] = 

	public static void markPrimes()
	{
		for(int i=2; i<MAX; i++)
			notPrime[i] = 0;

		for(int i=2; (i)*(i)<MAX; i++){

			if(notPrime[i] == 0){
				for(int j = 2*i; j<MAX; j = j+i)
					notPrime[j] = 1;
			}

		}
	}

	public static void main(String args[])
	{
			int count = 0;
			markPrimes();

			for(int i = 2; i<MAX; i++)
				if(notPrime[i] == 1)
					count++;
			System.out.println(count);
					

	}
}