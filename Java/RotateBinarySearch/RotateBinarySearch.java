public class RotateBinarySearch
{
	public static int  getPivort(int a[], int low, int high)
	{
		if(low > high)
			return -1;
		else if(low == high)
			return low;
		int mid = (low + high)/2;

		if(mid < high && a[mid] > a[mid+1])
			return mid;
		else if(mid > low && a[mid] < a[mid-1])
			return mid-1;
		else if(a[low] >= a[mid])
			return getPivort(a,low,mid-1);
		else
			return getPivort(a,mid+1,high);
	}

	public static int pivortedBinarySearch(int arr[], int key)
	{
		int p = getPivort(arr, 0, arr.length-1);

		if(p == arr.length-1)
			return binarySearch(arr,key,0,arr.length-1);
		else if(key == arr[p])
			return p;
		else if(key >= arr[0])
			return binarySearch(arr,key,0,p-1);
		else
			return binarySearch(arr, key, p+1, arr.length -1);

	}

	public static int binarySearch(int arr[], int key, int lb, int ub)
	{
		if(lb > ub)
			return -1;
		int mid = (lb+ub)/2;
		if(arr[mid] == key)
			return mid;
		else if(arr[mid] > key)
			return binarySearch(arr, key, lb,mid-1);
		else
			return binarySearch(arr, key, mid+1, ub);
	}

	public static void main(String args[])
	{
		int a[] = {3,4,5,1,2};
		System.out.println(pivortedBinarySearch(a,5));
		System.out.println(pivortedBinarySearch(a,1));
		System.out.println(pivortedBinarySearch(a,4));

	}
}