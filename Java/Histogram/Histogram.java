import java.util.*;

public class Histogram
{
	public static int getMaxArea(int arr[])
	{
		Stack<Integer> stk = new Stack<Integer>();
		stk.push(0);
		int maxArea = 0;
		int i=1;
		for(i=1; i<arr.length;){

			if(stk.isEmpty() || (arr[i] >= arr[stk.peek()])){
				stk.push(i);
				i++;
			}

			else{
				int top = stk.pop();
				int ar = 0;
				if(stk.isEmpty())
					ar = i*arr[top];
				else
					ar = arr[top]*(i-stk.peek()-1);
				if(ar > maxArea)
					maxArea = ar;
			}
		}
		while(!stk.isEmpty()){
			int top = stk.pop();
				int ar = 0;
				if(stk.isEmpty())
					ar = i*arr[top];
				else
					ar = arr[top]*(i-stk.peek()-1);
				if(ar > maxArea)
					maxArea = ar;
		}
		return maxArea;
	}
	public static void main(String ...args)
	{
		int arr[] = {6, 2, 5, 4, 5, 1, 6};
		System.out.println(getMaxArea(arr));
	}
}