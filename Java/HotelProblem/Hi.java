public class Solution 
{
    public static int count = 0;
    public int totalNQueens(int n) 
    {
        boolean board[][] = new boolean[n][n];
        count = 0;
        
        for(int i=0; i<n; i++){
            board[0][i] = true;
            isPossible(board,1);
            board[0][i] = false;
        }
        
        return count;
    }
    
    public void isPossible(boolean board[][], int i)
    {
        if(i == board.length){
            count++;
        }
        
        int n = board.length;
        
        for(int j=0; j<n; j++){
            
            if(isSafe(board,i,j)){
                board[i][j] = true;
                isPossible(board, i+1);
                board[i][j] = false;
            }
                
        }
     
    }
    
    public boolean isSafe(boolean board[][], int r, int c)
    {
        int i=0;
        int j=0;
        
        for(i=0; i<r; i++)
            if(board[i][c])
                return false;
        for(i= r-1,j= c-1; i>=0 && j >= 0; i--,j--)
            if(board[i][j])
                return false;
        for(i= r-1,j = c+1; i>=0 && j<board.length; i--,j++)
            if(board[i][j])
                return false;
        return true;
    }
    
    
}