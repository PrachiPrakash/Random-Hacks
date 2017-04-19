import java.io.*;

public class Farida
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = null;
		int t = 0;
		long buf[] = new long[10000];
		int n = 0;

			br = new BufferedReader(new InputStreamReader(System.in));
			t = Integer.parseInt(br.readLine());

			while(t-- > 0){
				n = Integer.parseInt(br.readLine());
				if(n == 0){
					br.readLine();
					System.out.println("Case "+(t+1)+": "+"0");
					continue;
				}
				String temp[] = br.readLine().split(" ");
				

				for(int i=0; i<n; i++)
					buf[i] = Long.parseLong(temp[i]);
				System.out.println("Case "+(t+1)+": "+getCount(buf, n));

			}
		
	}
	
	public static long getCount(long buf[], int n)
	{
		if(n == 0)
			return 0;
		if(n == 1)
			return buf[0];
		else if(n == 2)
			return Math.max(buf[0],buf[1]);

		long prevPrevMax = (long)buf[0];
		long prevMax = Math.max(buf[0],buf[1]);
		long max = Math.max(buf[0],buf[1]);

		for(int i = 2; i<n; i++){
			//long m = Math.max(prevPrevMax+buf[i],buf[i]);
			max = Math.max(prevPrevMax+buf[i],prevMax);
			prevPrevMax = prevMax;
			prevMax = max; 
		}

		return max;
	}
}