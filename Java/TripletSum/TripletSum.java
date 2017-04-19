import java.util.*;
public class TripletSum
{
	public static void getTripletSum(int arr[], int sum)
	{
		int len = arr.length-1;
		Arrays.sort(arr);

		for(int i =0; i<=len-2; i++){
			int lb = i+1;
			int ub = len;
			while(lb < ub){
				int t = arr[i] + arr[lb]+arr[ub];
				if(t == sum){
					System.out.println(i+" "+lb+" "+ub);
					break;
				}
				else if(sum > t)
					lb++;
				else
					ub--;
			}

		}
	}
	public static void main(String args[])
	{
		int arr[] = {4,1,2,3};
		getTripletSum(arr,7);
	}
}