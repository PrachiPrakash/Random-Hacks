import java.util.*;

class Pair implements Comparable<Pair>
{
	int a;
	int b;

	public Pair(int a, int b)
	{
		this.a = a;
		this.b = b;
	}

	public int compareTo(Pair ob)
	{
		if(a-ob.a == 0)
			return b-ob.b;
		else
			return a-ob.a;
	}
}
public class OverlapInterval
{
	public static void main(String args[])
	{
		Pair p[] = new Pair[4];
		p[0] = new Pair(1,3);
		p[1] = new Pair(7,9);
		p[2] = new Pair(4,6);
		p[3] = new Pair(10,13);

		Arrays.sort(p);
		boolean visited = false;

		for(int i=0; i<p.length-1; i++){
			if(p[i+1].a <= p[i].b){
				visited = true;
				System.out.println("true");
				break;
			}
		}

		if(!visited)
			System.out.println("false");
	}

}