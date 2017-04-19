public class RotateArray
{
	public static void rotate(int arr[], int d)
	{
		int nextElement = arr[arr.length - 1];

		for(int i=0; i<d; i++){
			nextElement = arr[arr.length -1];
			for(int j = arr.length-1; j >= 1; j--){
				int temp = arr[j-1];
				arr[j-1] = nextElement;
				nextElement = temp;
			}
			arr[arr.length - 1]= nextElement;
		}
	}

	public static void main(String args[])
	{
		int arr[] = {1,2,3,4,5,6,7};
		rotate(arr,2);
		for(int i=0; i<arr.length; i++)
			System.out.println(arr[i]);
	}
}
