import java.util.*;
public class HashMapNullEnrty
{
	public static void main(String args[])
	{
		Map<Integer,Integer> ob = new HashMap<Integer,Integer>();
		ob.put(null,2);
		System.out.println(ob.get(null));
	}

}