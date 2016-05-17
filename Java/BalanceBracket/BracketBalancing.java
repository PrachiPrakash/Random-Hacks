import java.util.*;

public class BracketBalancing
{
	public static int minChangesToBalance(String braces)
	{
		LinkedList<Character> stack = new LinkedList<Character>();
		char ch = 0;
		int count =0;

		if(braces.length() % 2 != 0)
			return -1;
		for(int i =0; i<braces.length(); i++){

			ch = braces.charAt(i);

			if(ch == '}' && stack.isEmpty()){
				count++;
				stack.addFirst('{');
			}

			else if(ch == '}')
				stack.poll();

			else
				stack.addFirst('{');


		}

		if(!stack.isEmpty())
			return count+stack.size()/2;
		else
			return count;
	}

	public static void main(String args[])
	{
		String s = "}{{}}{{{";
		System.out.println(minChangesToBalance(s));
	}
}