public class LeetCodeTriangle
{
	public static void main(String args[])
	{
		int arr[][] = {{2},{3,4},{6,5,7},{4,1,8,3}};
		//System.out.println(getMin(arr));
		System.out.println(getMinIterative(arr));
	}

	public static int getMin(int arr[][])
	{
		int min = Integer.MAX_VALUE;
		int k = 0;
		for(int i=0; i<arr.length; i++){
			if(i == 0)
				k = arr[arr.length-1][i]+getMinUtil(arr,arr.length-2,i);
			else if(i == arr.length-1)
				k = arr[arr.length-1][i]+getMinUtil(arr,arr.length-2,i-1);
			else
				k =arr[arr.length-1][i] +Math.min(getMinUtil(arr,arr.length-2,i),
													  getMinUtil(arr,arr.length-2,i-1));
			min = Math.min(k,min);
		}
		return min;
	}

	public static int getMinUtil(int arr[][],int i ,int j)
	{
		if(i == 0)
			return arr[0][0];
		else if(j == arr[i].length-1)
			return arr[i][j]+getMinUtil(arr, i-1,j-1);
		else if(j == 0)
			return arr[i][j]+getMinUtil(arr, i-1,j);
		else
			return arr[i][j]+Math.min(getMinUtil(arr,i-1,j),
									 getMinUtil(arr, i-1,j-1));
	}

	public static int getMinIterative(int arr[][])
	{
		if(arr.length == 0)
			return 0;
		else if(arr.length == 1)
			return arr[0][0];
		else if(arr.length == 2)
			return arr[0][0]+Math.min(arr[1][0],arr[1][1]);
		int curr[] = null;
		int prev[] = new int[arr.length];

		prev[0] = arr[0][0];
		int min = Integer.MAX_VALUE;

		for(int i=1; i<arr.length; i++){
			curr = new int[arr.length];
			min = Integer.MAX_VALUE;

			for(int j=0; j<=i; j++){
				if(j == 0)
					curr[j] = prev[j]+arr[i][j];
				else if(j == i){
					curr[j] = arr[i][j]+prev[j-1];
				}
				else
					curr[j] = arr[i][j]+Math.min(prev[j],prev[j-1]);

				min = Math.min(min,curr[j]);

				
			}

				if(i != arr.length-1)
					prev = curr;
		}
		
		return min;
	}
}