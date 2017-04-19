import java.util.*;
import java.io.*;

public class StoreCredit
{
	public static void main(String args[])
	{
		int arr[] = new int[2000];
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			for(int i=1; i<=t; i++){
				int c = Integer.parseInt(br.readLine());
				int n = Integer.parseInt(br.readLine());

				String lis[] = br.readLine().split(" ");

				for(int j =0; j<n; j++)
					arr[j] = Integer.parseInt(lis[j]);
				System.out.println("Case #"+i+": "+getCredit(arr,c,n));


			}
		
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}

	public static String getCredit(int arr[],int c,int n)
	{
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		int a = 0,b = 0;
		ArrayList<Integer> lis = null;

		for(int i=0; i<n; i++){
			if(!map.containsKey(arr[i])){
				lis = new ArrayList<Integer>();
				lis.add(i);
				map.put(arr[i],lis);
			}
			else{
				lis = map.get(arr[i]);
				lis.add(i);
				map.put(arr[i],lis);
			}
		}
		for(int i=0; i<n; i++){
			if(map.containsKey(c-arr[i]) && map.get(c-arr[i]).size() == 1 && map.get(c-arr[i]).get(0) != i){
				a = i;
				b = (map.get(c-arr[i])).get(0);
				break;
			}
			else if(map.containsKey(c-arr[i]) && map.get(c-arr[i]).size() > 1){
				a = i;
				b = (map.get(c-arr[i])).get(1);
				break;
			}
		}

		String temp = "";
		if(a > b)
			temp += (b+1)+" "+(a+1);
		else
			temp += (a+1)+" "+(b+1);
		return temp;

	}
}
