import java.util.*;

public class NextGreater
{
	public static void nextGreater(int arr[])
	{
		Stack<Integer> stk = new Stack<Integer>();
		stk.push(arr[0]);

		for(int next = 1; next < arr.length; next++){
			while(!stk.isEmpty() && stk.peek()  < arr[next])
				System.out.println(stk.pop()+"->"+arr[next]);
			stk.push(arr[next]);
		}
		while(!stk.isEmpty()){
			System.out.println(stk.pop() +"->"+"-1");
		}
	}

	public static void main(String args[])
	{
		int ar[] = {13, 7 , 6, 12};
		nextGreater(arr);
	}
}