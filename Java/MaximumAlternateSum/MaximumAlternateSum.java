public class MaximumAlternateSum
{
	

	public static int maxSum(int arr[])
	{
		if(arr.length == 1)
			return arr[0];
		int sum = arr[0];

		int sum1 = 0;
		sum1 = Math.max(arr[0], arr[1]);

		for(int i = 2; i<arr.length; i++){
			int m1 = Math.max(arr[i]+sum,arr[i]);
			int temp = sum1;
			sum1 = Math.max(m1,sum1);
			sum = temp;
		} 

		return sum1;
	}

	public static void main(String args[])
	{
		int a[] = {5, 5, 10, 100, 10, 5};
		int a2[] = {1, -100,7, 4};
		System.out.println(maxSum(a));
		System.out.println(maxSum(a2));
	}
}