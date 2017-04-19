import java.io.BufferedReader;
import java.io.InputStreamReader;


class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {
       

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int t = Integer.parseInt(line);
        
        while(t-- > 0){

        	int n = Integer.parseInt(br.readLine());
        	int shops[][] = new int[n][3];

        	for(int i=0; i<n; i++){
        		String temp[] = br.readLine().split(" ");
        		for(int j=0; j<2; j++)
        			shops[i][j] = Integer.parseInt(temp[j]);
        	}

        	int cost[][] = new int[n][3];

        	System.out.println(getMinCost(shops,cost,0,0,-1));

        }
       
    }

    public static int getMinCost(int shops[][], int cost[][], int i, int j,int k)
    {
    	if(i >= shops.length)
    		return 0;
    	else if(k != -1 && cost[i][j] > 0)
    		return cost[i][j];
    	else{
    		if(k == -1){
    			cost[i][0] = shops[i][0]+Math.min(getMinCost(shops,cost,i+1,1,0),getMinCost(shops,cost,i+1,2,0));
    			System.out.println(cost[i][0]);
    			cost[i][1] = shops[i][1]+Math.min(getMinCost(shops,cost,i+1,0,1),getMinCost(shops,cost,i+1,2,1));
    			System.out.println(cost[i][1]);
    			cost[i][2] = shops[i][2]+Math.min(getMinCost(shops,cost,i+1,0,2),getMinCost(shops,cost,i+1,1,2));
    			System.out.println(cost[i][2]);

    			int m1 = Math.min(cost[i][0],cost[i][1]);
    			return Math.min(cost[i][2],m1);
    		}
    		else if(k == 0){
    			cost[i][j] = shops[i][j]+Math.min(getMinCost(shops,cost,i+1,0,1),getMinCost(shops,cost,i+1,2,1));
    			return cost[i][j];
    			
    		}
    		else if(k == 1){
    			cost[i][j] = shops[i][j]+Math.min(getMinCost(shops,cost,i+1,1,0),getMinCost(shops,cost,i+1,2,0));
    			return cost[i][j];
    		}
    		else {//2
    			cost[i][j] = shops[i][0]+Math.min(getMinCost(shops,cost,i+1,1,0),getMinCost(shops,cost,i+1,2,0));
    			return cost[i][j];
    		}
    	}
    }
}
