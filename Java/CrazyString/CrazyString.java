public class CrazyString
{
	public static void main(String args[])
	{
		String input[] = {"ABC","CPQ","QRS","STU","CAD","DAS","UTA","ACU","SCA"};
		int mat[][] = constructGraph(input);


		for(int i=0; i<input.length;i++){
			for(int j = 0; j<input.length; j++)
				System.out.print(mat[i][j]);
			System.out.println();
		}
		int visited[] = new int[input.length];
		int max[] = new int[input.length];

		for(int i=0; i<input.length; i++)
			max[i] = input[i].length();

		for(int i=0; i<input.length; i++)
			if(visited[i] == 0)
				dfsVisit(mat,i,visited, max,input);

		int m = max[0];

		for(int i=1; i<input.length; i++){
			if(max[i] > m)
				m = max[i];
		}

		System.out.println(m);


	}

	static int dfsVisit(int mat[][], int i, int visited[], int max[], String input[])
	{
		visited[i] = 1;
		for(int j =0; j<mat.length; j++){
			if(visited[j] == 0 && mat[i][j] == 1){
				int m = dfsVisit(mat,j,visited, max,input);
				if(m+input[i].length() > max[i])
					max[i] = m+input[i].length(); 
			}
			else if(visited[j] == 2 && mat[i][j] == 1){
				if(max[j]+input[i].length() > max[i])
					max[i] = max[j]+input[i].length();
			}
		}
		visited[i] =2;
		return max[i];

	}

	static int[][] constructGraph(String input[])
	{
		int mat[][] = new int[input.length][input.length];

		for(int i=0; i<input.length; i++){
			for(int j = 0; j<input.length; j++){

				if(input[i].charAt(input[i].length()-1) == input[j].charAt(0) && i!=j)
					mat[i][j] = 1;
			}
		}

		return mat;
	}
	
}