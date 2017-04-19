import java.util.*;

class GraphNode
{
	int id;
	int d;
	int f;
	List<Edge> adj;
	public GraphNode(int id)
	{
		this.id = id;
		adj = new ArrayList<Edge>();
	}
}
class Edge
{
	int v;
	int w;
	public Edge(int v)
	{
		this.v = v;
	}
	public Edge(int v, int w)
	{
		this(v);
		this.w = w;
	}
}

class Graph
{
	GraphNode g[];
	public Graph(int n)
	{
		g = new GraphNode[n];

		for(int i=0; i<n; i++){
			g[i] = new GraphNode(i);

		}
	}

	public void addEdge(int u,int v,boolean isUndirected)
	{
		g[u].adj.add(new Edge(v));

		if(isUndirected)
			g[v].adj.add(new Edge(u));
	}

	public void addEdge(int u, int v, int w, boolean isUndirected)
	{
		g[u].adj.add(new Edge(v,w));

		if(isUndirected)
			g[v].adj.add(new Edge(u,w));
	}

	public void DFS()
	{
		
		boolean visited[] = new boolean[g.length];

		for(int i=0; i<g.length; i++){
			if(!visited[i])
				DFSVisit(i,visited);
		}

	}

	public void DFSVisit(int i, boolean visited[])
	{
		
		

		Stack<GraphNode> context = new Stack<GraphNode>();
		int ind[] = new int[g.length];

		context.push(g[i]);

		while(!context.isEmpty()){

			GraphNode curr = context.pop();

			if(ind[curr.id] == 0){
				visited[curr.id] = true;
				System.out.println(curr.id);
			}
			if(ind[curr.id] == curr.adj.size())
				continue;
			int j = ind[curr.id];
			for(j = ind[curr.id]; j<curr.adj.size(); j++){
				if(!visited[curr.adj.get(j).v])
					break;
				ind[curr.id]++;
			}

			if(ind[curr.id] == curr.adj.size())
				continue;
			ind[curr.id]++;
			context.push(curr);
			context.push(g[curr.adj.get(j).v]);

		}
	}


}

public class IterativeDFS
{
	public static void main(String args[])
	{
		Graph g = new Graph(4);

		g.addEdge(0,1,true);
		g.addEdge(0,2,true);
		g.addEdge(1,3,true);
		g.addEdge(2,3,true);

		g.DFS();
	}
}