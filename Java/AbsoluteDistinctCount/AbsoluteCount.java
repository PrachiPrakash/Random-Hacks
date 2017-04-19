public class AbsoluteCount
{
	public static int getDistinctCount(int arr[])
	{
		int l = arr.length - 1;
		int i = 0;
		int j = l;
		int count = l+1;
		
		while(i < j){
			while(i != j && arr[i] == arr[i+1]){
				count--;i++;
			}
			while(i != j && arr[j]==arr[j-1]){
				count--;j--;
			}
			if(i != j){
				int sum = arr[i] + arr[j];
				if(sum == 0){
					count--;i++;j--;
				}
				else if(sum > 0)
					j--;
				else
					i++;
			}
		}
		return count;
	}
	public static void main(String args[])
	{
		int arr[] = {-2,-1,0,1,1};
		System.out.println(getDistinctCount(arr));
	}
}
