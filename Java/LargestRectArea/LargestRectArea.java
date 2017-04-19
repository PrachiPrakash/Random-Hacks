import java.io.*;
import java.util.*;

public class LargetsRectArea
{
	public static void main(String args[])throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0){
			int n = Integer.parseInt(br.readLine());
			int m = Intger.parseInt(br.readLine());

			int arr[][] = new int[3][n];
			HashSet<Integer> lis = new HashSet<Integer>();


			for(int i = 1; i<=m; i++){

				int r = Integer.parseInt(br.readLine())-1;
				int s = Integer.parseInt(br.readLine())-1;
				int e = Integer.parseInt(br.readLine())-1;


				for(int j=s; j<=e; j++)
					arr[r][j] = 1;


			}

			System.out.println(findRectArea(arr));
		}

	}

	public static int findRectArea(int arr[][])
	{

	}
}