import java.util.*;

public class PairSum
{
	public static int getPairSum(int list[],int sum)
	{
		HashMap<Integer,Integer> ob = new HashMap<Integer,Integer>();
		int count = 0;
		for(int i =0; i<list.length; i++){
			
			if(ob.get(list[i]) == null)
				ob.put(list[i],1);
			else
				ob.put(list[i],ob.get(list[i])+1);

		}
		for(int i = 0; i<list.length; i++){
			
			if(ob.get(sum-list[i]) != null){
				count += ob.get(sum-list[i]);
				if(sum-list[i] == list[i])
					count--;
			}
		}

		return count/2;

	}

	public static void main(String args[])
	{
		int arr[] = {1,1,1,1};
		System.out.println(getPairSum(arr,2));
	}
}
