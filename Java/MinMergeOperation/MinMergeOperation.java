public class MinMergeOperation
{
	public static int minMerges(int arr[])
	{
		int lb = 0;
		int ub = arr.length - 1;
		int mCount = 0;

		while(lb < ub){

			if(arr[lb] == arr[ub]){
				lb++;
				ub--;
			}
			else if(arr[lb] < arr[ub]){
				mCount++;
				arr[lb +1] = arr[lb]+arr[lb+1];
				lb++;
			}
			else{
				mCount ++;
				arr[ub - 1] = arr[ub]+arr[ub-1];
				ub--;
			}
		}

		return mCount;

	}

	public static void main(String args[])
	{
		int a[] = {15, 4, 15};
		System.out.println(minMerges(a));

		int b[] = {1, 4, 5, 1};
		System.out.println(minMerges(b));

		int c[] = {11, 14, 15, 99};
		System.out.println(minMerges(c));
	}
}