public class PairSumRotatedArray
{
	public static int getPivort(int arr[], int lb, int ub)
	{
		if(lb > ub)
			return -1;
		else if(lb == ub)
			return lb;
		int mid = (lb + ub)/2;

		if(mid < ub && arr[mid] > arr[mid+1])
			return mid;
		else if(lb < mid && arr[mid] < arr[mid -1])
			return mid -1 ;
		else if(arr[lb] > arr[mid])
			return getPivort(arr,lb,mid-1);
		else
			return getPivort(arr,mid+1, ub);
	}

	public static void getSum(int arr[], int sum)
	{
		int l = arr.length;

		int ub = getPivort(arr,0, l-1);
		System.out.println("ub "+ub);
		int lb = (ub+1)%l;
		System.out.println("lb "+lb);

		while(lb != ub){
			if(arr[lb] + arr[ub] == sum){
				System.out.println(lb+" "+ub);
				return;
			}
			else if(sum > arr[lb]+arr[ub])
				lb = (lb+1)%l;
			else{
				ub = (ub - 1)%l;
				if(ub < 0)
					ub = ub + l;
			}
		}

		System.out.println("not found!!!");
	}

	public static void main(String args[])
	{
		int a[] = {3,4,5,1,2};
		getSum(a,3);
	}
}