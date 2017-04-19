public class AutomataMatching
{
	public static int[][] getAutomata(String pattern)
	{
		int fa[][] = new int[pattern.length()+1][256];
		for(int i = 1; i<=pattern.length(); i++)
			for(int j=0; j<256; j++)
				fa[i][j] = getNextState(pattern,i,j);

		return fa;
	}

	public static int getNextState(String pattern, int state, int x)
	{
		if(pattern.charAt(state-1) == x)
			return state+1;

		for(int i  = state; i>0; i--){
			if(pattern.charAt(i-1) == x){
				int j =0;
				for(j = 0; j<i-1; j++ ){
					if(pattern.charAt(j) != pattern.charAt(state - i+1+j))
						break;
				}
				if(j == i-1)
					return i;
			}
		}

		return 0;
	}


	public static void main(String args[])
	{
		String t = "AABAACAADAABAAABAA";
		String p = "AABA";

		int fs[][] = getAutomata(p);

		for(int i=0; i<fs.length; i++){
			for(int j=0; j<256; j++)
				System.out.print(fs[i][j]+"\t");
			System.out.println("");
		}

		System.out.println(fs[3][65
			]);


	}
 }