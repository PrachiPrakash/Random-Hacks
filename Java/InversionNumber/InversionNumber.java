public class InversionNumber
{
	public static void main(String ...args)
	{
		int a[]= {1,20,6,4,5};
		long count = mergeSort(a,0,a.length-1);
		System.out.println(count);
		
		for(int i=0; i<a.length; i++)
			System.out.println(a[i]);
		 
	}
	
	public static long mergeSort(int ar[],int lb,int ub)
	{
		int mid =0;
		if(lb == ub)
			return 0;
		else{
			
			mid = (lb+ub)/2;
			long c1 = mergeSort(ar,lb,mid);
			long c2 = mergeSort(ar,mid+1,ub);
			c2 = merge(ar,lb,mid,ub,c1+c2);
			return c2;
		}
	}
	
	public static long merge(int ar[],int lb,int mid,int ub,long count)
	{
		int temp[] = new int[ub-lb+1];
		int k = 0;
		int i = lb, j = mid+1;
		
		while(i<=mid && j<=ub){
		
			if(ar[i] <= ar[j])
				temp[k++] = ar[i++];
				
			else{
				temp[k++] = ar[j++];
				count = count + (mid-i+1);
			}
			
		}
		
		while(i <= mid){
			temp[k++] = ar[i++];
		}
		
		while(j <= ub)
			temp[k++] = ar[j++];
		k =0;
		
		for(i=lb; i<=ub; i++)
			ar[i] = temp[k++];
		
		return count;
	}
}
