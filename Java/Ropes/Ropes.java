
import java.io.BufferedReader;
import java.io.InputStreamReader;


class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {
    	   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n = 0;
        int low[];
        int high[];
        
        while(t-- > 0){
        	
        	n = Integer.parseInt(br.readLine());
        	low = new int[n+1];
        	high = new int[n+1];
        	
        	String t1[] = br.readLine().split(" ");
        	String t2[] = br.readLine().split(" ");
            System.out.println(t1.length);
            System.out.println(t2.length);
        	
        	for(int i=1; i<n; i++){
        		low[i] = Integer.parseInt(t1[i-1]);
        		high[i] = Integer.parseInt(t2[i-1]);
        		}
        	
        	long sum[] = new long[n+1];
        	
        	for(int i=1; i<n; i++){
        		long temp = Math.max((long)low[i],(long)high[i])+1;
        		sum[i] = Math.max(sum[i-1],temp);
        	}
        	
        	System.out.println(Math.max((long)n,sum[n-1]));
        	
        	
        	
        }
    }
}
