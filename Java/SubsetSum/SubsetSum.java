public class SubsetSum
{
	public static boolean isSubsetSum(int arr[],int sum)
	{
		boolean sums[] = new boolean[sum+1];
		sums[0] = true;
		for(int i = 1; i<=sum; i++){
			for(int j=0; j<arr.length; j++){
				if(i-arr[j]>=0 && sums[i - arr[j]]){
					sums[i] = true;
					break;
				}
			}
		}

		return sums[sum];
	}

	public static void main(String args[])
	{
		int arr[] = {3, 34, 4, 12, 5, 2};
		System.out.println(isSubsetSum(arr,9));
	}
}