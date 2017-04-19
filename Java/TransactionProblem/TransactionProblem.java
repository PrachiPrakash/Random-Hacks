public class TransactionProblem
{
	public static int  getAnswer(int arr[],boolean op, int i, int t, int p)
	{
		if(i >= arr.length)
			return 0;
		if(t == 0)
			return 0;
		if(op == true){
			return Math.max(p-arr[i]+getAnswer(arr,false,i+1,t-1,p-arr[i]),
							p+getAnswer(arr,true,i+1,t,p));
		}
		else{
			return Math.max(p+arr[i]+getAnswer(arr,true,i+1,t-1,p+arr[i]),
							p+getAnswer(arr,false,i+1,t,p));
		}
	}

	public static void main(String args[])
	{
		int arr[] = {10,22,5,75,65,80};
		System.out.println(getAnswer(arr,true,0,4,0));
	}
}