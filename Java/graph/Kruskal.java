import java.util.*;
import java.io.*;

class Pair<K,V>
{
	K first;
	V second;

	Pair(K first,V second)
	{
		this.first = first;
		this.second = second;
	}

	@Override
	public String toString()
	{
		return first.toString() + " "+second.toString();
	}

}

public class Kruskal
{
	public static List<Pair<Integer,Pair<Integer,Integer>>> graph = 
											new ArrayList<Pair<Integer,Pair<Integer,Integer>>>();

	public static int id[] = new int[100000];

	public static void initialize()
	{
		for(int i=0; i<id.length; i++)
			id[i] = i;
	}

	public static int root(int x)
	{
		while(id[x] != x){
			id[x] = id[id[x]];
			x = id[x];
		}
		return x;
	}
	public static void union(int x, int y)
	{
		int r = root(x);
		int r2 = root(y);

		id[r2] = x;
	} 	
	public static int getCost(List<Pair<Integer,Pair<Integer,Integer>>> g)
	{
		int cost = 0;
		for(Pair<Integer,Pair<Integer,Integer>> e : g){
			int u = e.second.first;
			int v = e.second.second;
			int c = e.first;

			if(root(u) != root(v)){
				cost += c;
				union(u,v);

			}
		}

		return cost;
	}
	public static void main(String ...args)throws Exception
	{
		String temp[] = null;
		String inp = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		inp = br.readLine();
		temp = inp.split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);

		for(int i =0; i<m; i++){
			inp = br.readLine();
			temp = inp.split(" ");
			graph.add(makePair(Integer.parseInt(temp[0]),
								Integer.parseInt(temp[1]),
								Integer.parseInt(temp[2])));
		}
		initialize();

		Collections.sort(graph, new Comparator<Pair<Integer,Pair<Integer,Integer>>>(){
			@Override
			public int compare(Pair<Integer,Pair<Integer, Integer>> o1,
								Pair<Integer,Pair<Integer, Integer>> o2)
			{
				return o1.first-o2.first;
			}
		});

		System.out.println(getCost(graph));

	}

	public static Pair<Integer,Pair<Integer,Integer>> makePair(int u, int v, int w)
	{
		Pair<Integer,Integer> p = new Pair<Integer,Integer>(u,v);
		return new Pair<Integer,Pair<Integer,Integer>>(w,p);
	}
}