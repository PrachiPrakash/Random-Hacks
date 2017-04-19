import java.util.*;

public class Anagaram
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);

	}

	public static int getMinChanges(String input)
	{
		int len = input.length();

		if(len % 2 != 0)
			return -1;

		int mid = (0 + (len-1))/2;
		String firstString = input.substring(0,mid);
		String secondString = input.substring(mid,len);
		int countFirst[] = new int[26];
		int countSecond[] = new int[26];
		int changeFirst = 0; 				//no of changes in the first string
		int changeSecond = 0; 				//no of changes int the second string


		for(int i = 0; i<=mid-1; i++){

			countFirst[firstString[i]-97]++;
			countSecond[secondString[i]-97]++;
		}

		//for calculating the number of changes in the first string

		for(int i = 0; i<mid; i++){
			int 
		}
	}
}