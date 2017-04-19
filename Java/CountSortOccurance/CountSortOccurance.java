public class CountSortOccurance
{
	public static int getCount(int arr[], int x)
	{
		int lb = 0;
		int ub = arr.length - 1;

		while(lb <= ub)
		{
			int mid = (lb + ub)/2;
			System.out.println(lb+" "+ub);

			if(arr[mid] == x){
				if(arr[lb] == x && arr[ub] == x){
					System.out.println(lb+" "+ub);
					return ub-lb+1;
				}
				else if(arr[lb] == x && arr[mid+1] != x)
					return mid-lb+1;
				else if(arr[ub] == x && arr[mid-1] != x)
					return ub-mid+1;
				
				if(arr[mid] == arr[mid-1] && arr[lb] != x){
					int m2 = (lb+mid-1)/2;
					if(arr[m2] < x)
						lb = m2 +1;
					else if(arr[m2] == x && arr[m2-1] != x)
						lb = m2;
				}
				if(arr[mid] == arr[mid+1] && arr[ub] != x){
					int m2 = (ub+mid+1)/2;
					if(arr[m2] > x)
						ub = m2-1;
					else if(arr[m2] == x && arr[m2+1] != x)
						ub = m2;
				}
			}
			else if(arr[mid] > x)
				ub = mid - 1;
			else
				lb = mid+1;
		}

		return -1;
	}
	public static void main(String args[])
	{
		int a[] = {1,1,2,2,2,2,3};
		System.out.println(getCount(a,4));
	}
}