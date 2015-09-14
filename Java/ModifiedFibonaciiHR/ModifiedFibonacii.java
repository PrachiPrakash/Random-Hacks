import java.util.Scanner;
import java.math.BigInteger;

public class ModifiedFibonacii
{
	public static void main(String ...args)
	{
			int a,b,n;
			Scanner s = new Scanner(System.in);
			
			a = s.nextInt();
			b = s.nextInt();
			n = s.nextInt();
		
		
			
			printSequence(0,1,5);
			
	}
	
	public static void printSequence(int a,int b,int n)
	{
		if(n == 1)
			System.out.println(a);
		else if(n == 2)
			System.out.println(b);
		else{
			
			BigInteger tempA = new BigInteger(a+"");
			BigInteger tempB = new BigInteger(b+"");
			BigInteger temp = null;
			
			int i=1;
			while(i <= n-2){
				temp = tempB.add(BigInteger.valueOf(0)); 
				tempB = tempA.add(tempB.pow(2));
				tempA = temp.add(BigInteger.valueOf(0));
				i++;
			}
			
			System.out.println(tempB);
		}
		
	}
}
