import java.util.*;

public class StackSort
{
	public static void removeElement(Stack<Integer> s)
	{
		if(!s.empty()){
			int e = s.pop();
			removeElement(s);
			putrightPlace(s,e);
		}
	}
	public static void putrightPlace(Stack<Integer> s,int e)
	{
		if(s.empty() || e >=s.peek())
			s.push(e);
		else{
			int k = s.pop();
			putrightPlace(s,e);
			s.push(k);
		}

	}
	public static void main(String args[])
	{
		Stack<Integer> s=  new Stack<Integer>();
		
		s.push(10);
		s.push(5);
		s.push(1);
		s.push(2);

		System.out.println(s);
		removeElement(s);
		System.out.println(s);
	}
}