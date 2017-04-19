public class BitDifference
{
	public static int getBitDifference(int arr[])
	{
		int count = 0;
		int ans = 0;
		for(int i = 1; i<=32; i++){
			count = 0;
			for(int j = 0; j<arr.length; j++)
				if((arr[j] & (1<<i)) == (1 << i))
					count++;
			ans += 2*count*(arr.length - count);
		}

		return ans;
	}
	public static void main(String args[])
	{
		int arr[] = {1,3,5};
		System.out.println(getBitDifference(arr));
	}
}
