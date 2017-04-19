public class SortedArray
{
	public static void printSubArray(int a[], int b[], int la, int lb, boolean flag,String res,int num,int len)
	{
		if(flag == true){
			if(la >= a.length)
				return;
			if(len == 0){
				for(int i = la; i<a.length; i++)
					printSubArray(a,b,i,lb,false,res+" "+a[i],a[i],1);
			}
			else{
				int i = la;
				while(i<a.length && a[i]<=num)
					i++;
				if(i >= a.length)
					return;
				printSubArray(a,b,i+1,lb,false,res+" "+a[i],a[i],1);

			}

		}

		else{
			if(lb >= b.length)
				return;
			int i = lb;
			while(i<b.length){

				if(b[i] > num){
					System.out.println(res+" "+b[i]);
					printSubArray(a,b,la+1,i+1,true,res+" "+b[i],b[i],1);
				}

				i++;
			}
			
			

		}
	}
	public static void main(String args[])
	{
		int a[] = {10,15,25};
		int b[] = {1,5,20,30};

		printSubArray(a,b,0,0,true,"",0,0);
	}
}