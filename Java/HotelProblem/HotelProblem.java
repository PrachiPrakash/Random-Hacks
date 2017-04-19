import java.io.*;
import java.util.*;

public class HotelProblem
{
	public static void main(String args[])throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0){
			int n = Integer.parseInt(br.readLine());
			if(n == 0){
				System.out.println(n);
				continue;
			}
			String a[] = br.readLine().split(" ");
			String e[] = br.readLine().split(" ");

			if(n == 1){
				System.out.println(n);
				continue;
			}

			int arrival[] = new int[n];
			int dep[] = new int[n];

			for(int i=0; i<n; i++){
				arrival[i] = Integer.parseInt(a[i]);
				dep[i] = Integer.parseInt(e[i]);
			}

			Arrays.sort(arrival);
			Arrays.sort(dep);

			System.out.println(getMaxCustomers(arrival,dep));
		}
	}

	public static int getMaxCustomers(int a[], int d[])
	{

		int i = 1;
		int j = 0;
		int n = a.length;
		int max = 1;
		int currMax = 1;

		while(i < n && j < n){
			if(a[i] >= d[j]){
				currMax--;
				j++;
			}
			else{
				currMax++;
				if(currMax > max)
					max = currMax;
				i++;
			}
		}

		return max;
	}
}