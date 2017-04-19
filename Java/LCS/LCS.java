public class LCS
{
	public static int getLCSLength(String s1,String s2, int i, int j)
	{
		if(i == -1 || j == -1)
			return 0;
		else if(s1.charAt(i) == s2.charAt(j))
			return 1+getLCSLength(s1, s2, i-1,j-1);
		else
			return Math.max(getLCSLength(s1,s2, i-1,j),getLCSLength(s1,s2,i,j-1));
	}
	public static int getLCSLength(String s1, String s2)
	{
		int mem[][] = new int[s1.length()+1][s2.length()+1];

		for(int i=1; i<=s1.length(); i++){
			for(int j = 1; j<=s2.length(); j++){
				if(s1.charAt(i-1) == s2.charAt(j-1))
					mem[i][j] = mem[i-1][j-1]+1;
				else
					mem[i][j] = Math.max(mem[i][j-1],mem[i-1][j]);
			}
		}
		printAString(mem, s1, s2);

		return mem[s1.length()][s2.length()];
	}
	public static void printAString(int mem[][],String s1, String s2)
	{
		int i = s1.length();
		int j = s2.length();

		StringBuilder b = new StringBuilder();

		while(i > 0 && j > 0){
			if(s1.charAt(i-1) == s2.charAt(j-1)){
				b.insert(0,s1.charAt(i-1));
				i--;
				j--;
			}
			else if(mem[i-1][j] > mem[i][j-1])
				i--;
			else
				j--;
		}
		System.out.println(b.toString());
	}
	public static void main(String args[])
	{
		System.out.println(getLCSLength("ABDAB","ACBAB",4,4));
		System.out.println(getLCSLength("ABDAB","ACBAB"));
	}
}