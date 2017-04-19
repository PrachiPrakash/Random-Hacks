/**
*This program checks whether given preorder sequence can form a Binary Search tree or not
*@author Prachi Prakash
*/
import java.util.*;

public class ValidPreortderBST
{

	public static boolean checkValidSequence(int sequence[])
	{
		Stack<Integer> stack = new Stack<Integer>();
		int curRoot = Integer.MIN_VALUE;

		for(int i=0; i<sequence.length; i++){
			if(sequence[i] < curRoot)
				return false;
			while(!stack.empty() && sequence[i] > stack.peek())
				curRoot = stack.pop();
			
			stack.push(sequence[i]);
		}

		return true;
	}
	public static void main(String args[])
	{
		int seq[] = {10,7,6,5,22,1};
		System.out.println(checkValidSequence(seq));
	}
}