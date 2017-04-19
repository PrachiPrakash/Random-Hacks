import java.util.*;
class Job
{
	int index;
	int priority;

	public Job(int index, int priority)
	{
		this.index = index;
		this.priority = priority;

	}
}
public class PrinterQueue
{
	public static void main(String args[])
	{
		int p[] = new int[100];
		LinkedList<Job> jobs = new LinkedList<Job>();
		int n = 0, m =0, t = 0, count = 0;
		Job curr = null; 

		try{

			Scanner in = new Scanner(System.in);

			t = in.nextInt();

			while(t-- > 0){

				n = in.nextInt();
				m = in.nextInt();

				for(int i=0; i<n; i++){

					p[i] = in.nextInt();
					jobs.add(new Job(i,p[i]));
				}

				count = 0;
				Arrays.sort(p,0,n);
				int ind = n - 1;

				while(true){
					curr = jobs.pollFirst();


					if(curr.index == m && p[ind] == curr.priority){
						count++;
						break;
					}
					else if(curr.priority == p[ind]){
						count++;
						ind--;
					}

					else
						jobs.add(curr);

				}

				System.out.println(count);
				jobs.clear();

			}
		}

			catch(Throwable ta){
				ta.printStackTrace();
			}

	}
}