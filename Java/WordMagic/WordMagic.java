public class WordMagic
{

	static boolean findWordInAGrid(char grid[][], int m, int n,String word)
	{
		
		for(int i = 0; i<m; i++){
			for(int j = 0; j<n; j++){
				boolean res = findWordInAGrid(grid, m,n,word,0,i,j);
				if(res)
					return true;
			}
		}
		return false;
		 
	}

	 static boolean findWordInAGrid(char grid[][], int m, int n, String word, int ind, int i, int j)
	{

		if(ind == word.length())
			return true;
		else if(i >= m || j>=n)
			return false;
		else if(i < 0 || j < 0)
			return false;

		


		System.out.println(grid[i][j] + " "+word.charAt(ind));

		if(grid[i][j] != word.charAt(ind))
			return false;
		ind++;

		boolean res =  findWordInAGrid(grid, m,n,word,ind,i,j+1) ||
				findWordInAGrid(grid, m,n,word,ind,i+1,j) ||
				findWordInAGrid(grid, m,n,word,ind,i-1,j) ||
				findWordInAGrid(grid, m,n,word,ind,i,j-1) ||
				findWordInAGrid(grid, m,n,word,ind,i+1,j+1) ||
				findWordInAGrid(grid, m,n,word,ind,i-1,j-1) ||
				findWordInAGrid(grid, m,n,word,ind,i+1,j-1) ||
				findWordInAGrid(grid, m,n,word,ind,i-1,j+1) ;   
		
		return res;
	}

	public static void main(String args[])
	{
		char grid[][] = {{'a','b','c'},
						{'d','e','f'},
						{'g','h','i'}};
		System.out.println(findWordInAGrid(grid,3,3,"efhi"));
	}
}