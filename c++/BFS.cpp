#include <iostream>
#include <list>

using namespace std;

class Graph
{
	private:
		int v;
		list<int> *adj;
		int s;
		int *distance;
	public:
		Graph(){}
		void addEdge(int u,int v);
		void bfs();
		void setSource(int s){this->s = s;}
		void printDistance();
		void setVertex(int v);
};


void Graph::setVertex(int v)
{
	this->v = v;
	adj = new list<int>[v];
	distance = new int[v];
}

void Graph::addEdge(int u, int v)
{
	adj[u].push_back(v);
	adj[v].push_back(u);
}

void Graph::bfs()
{
	bool *visited = new bool[v];
	list<int> queue;
	
	for(int i=0; i<v; i++){
		visited[i] = false;
		distance[i] = -1;
	}

	visited[s] = true;
	distance[s] = 0;

	queue.push_back(s);

	while(!queue.empty()){
		int u = queue.front();
		queue.pop_front();

		for(list<int>::iterator v =adj[u].begin(); v != adj[u].end();  v++){
		
			if(!visited[*v]){
				queue.push_back(*v);
				distance[*v] = distance[u]+1;
				visited[*v] = true;
			}
		}
	}

	delete visited;

	for(int i=0; i<this->v; i++){
		if(distance[i] != -1)
			distance[i] *= 6;
	}

}

void Graph::printDistance()
{
	for(int i=0; i<v; i++){
		if(i != s)
			cout <<distance[i]<<" ";
	}
}

int main()
{
	int v = 0, e = 0 ,s = 0,t;
	int uTemp,vTemp;
	cin >> t;
	Graph *g = new Graph[t];
	for(int i=0; i<t; i++){
		cin >> v >> e;
		g[i].setVertex(v);
		for(int j=0; j<e; j++){
			cin >>uTemp>>vTemp;
			g[i].addEdge(uTemp-1,vTemp-1);
		}
		cin >> s;
		g[i].setSource(s-1);
		g[i].bfs();
		
	}
	
	for(int i=0; i<t; i++){
		g[i].printDistance();
		cout<<"\n";
	}
	return 0;
}
