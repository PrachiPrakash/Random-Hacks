import java.util.*;

public class LargestSubset
{
	public static int getLargestSubset(Integer arr[], int i)
	{
		if(i >= arr.length)
			return 0;
		int max = 1;
		for(int j= i+1; j<arr.length; j++){
			if(arr[i] % arr[j] == 0 || arr[j] % arr[i] == 0){
				int p = 1+ getLargestSubset(arr, j);
				if(p > max)
					max = p;
			}

		}

		return max;
	}

	public static List<Integer> getLargestSubset(Integer arr[])
	{
		ArrayList<ArrayList<Integer>> ob = new ArrayList<ArrayList<Integer>>(arr.length);
        
        if(arr.length == 0)
            return new ArrayList<Integer>();

		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(arr[0]);
		ob.add(temp);
		int max = 0;

		for(int i=1; i<arr.length; i++){
			temp = new ArrayList<Integer>();
			int j = 0;
			while(j <= i-1) 
			{
                    
                    
                        if(arr[j] % arr[i]  == 0 
							|| arr[i] % arr[j]== 0){
							    temp.add(arr[j]);
							}
						
                    
                    
					j++;
			}
			
			temp.add(arr[i]);

			ob.add(temp);

			if(temp.size() > ob.get(max).size())
				max = i;

		}

		for(int i =0; i<arr.length; i++)
			System.out.println(ob.get(i).toString());

		System.out.println("-----------------------------------------------------");

		return ob.get(max);  

	}

	public static void main(String args[])
	{
		ArrayList<Integer> ob = new ArrayList<Integer>();
		Scanner in = new Scanner(System.in);

		while(in.hasNextInt())
			ob.add(in.nextInt());
		System.out.println(getLargestSubset(ob.toArray(new Integer[ob.size()])).toString());

	}



}