import java.util.*;

public class CoinChange
{
	public static void main(String args[])
	{
		int arr[] = {2};
		System.out.println(getMinCoins(arr,3));
	}

	public static int getMinCoins(int arr[], int sum, int i)
	{
		if(sum == 0)
			return 0;
		else if(i >= arr.length)
			return Integer.MAX_VALUE -2;
		
		else if(sum < 0)
			return Integer.MAX_VALUE-2;
		else
			return Math.min(1+Math.min(getMinCoins(arr,sum-arr[i],i),1+getMinCoins(arr,sum-arr[i],i+1)),
					getMinCoins(arr,sum,i+1));
	}

	public static int getMinCoins(int arr[], int sum)
	{
		int sumMemory[] = new int[sum+1];
		sumMemory[0] = 0;
		for(int i=1; i<=sum; i++)
			sumMemory[i] = Integer.MAX_VALUE-2;

		for(int i = 1; i<=sum; i++){

			for(int j = 0; j<arr.length; j++){
				if(i-arr[j] >= 0)
					sumMemory[i] = Math.min(sumMemory[i-arr[j]]+1,sumMemory[i]);
			}

		}

		if(sumMemory[sum] == Integer.MAX_VALUE-2)
			return -1;
		else
			return sumMemory[sum];
	}

}