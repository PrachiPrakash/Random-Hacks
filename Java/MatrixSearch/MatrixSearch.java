public class MatrixSearch
{
	public static void serachInMatrix(int arr[][], int x)
	{
		int i = 0;
		int j = arr[0].length - 1;
		while(i < arr.length && j>=0){
			if(arr[i][j] == x){
				System.out.println(i+" "+j);
				return;
			}
			else if(arr[i][j] > x)
				j--;
			else
				i++;
		}
		System.out.println("Not Found!!!");
	}
	public static void main(String args[])
	{
		int arr[][] = { {10, 20, 30, 40},
                    {15, 25, 35, 45},
                    {27, 29, 37, 48},
                    {32, 33, 39, 50},
                  };
        serachInMatrix(arr, 29);
	}
}