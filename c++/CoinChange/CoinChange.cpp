#include <iostream>

using namespace std;
long long GetNumWays(int *,int ,int);

int main()
{
	int n,m;
	int *c;

	cin >>n >> m;

	c = new int[m];
	for(int i=0; i<m; i++)
		cin >> c[i];
	cout << GetNumWays(c,n,m) <<endl;

	return 0;
}

long long GetNumWays(int *c, int n, int m)
{
	long long *mem = new long long[n+1];

	for(int i=1; i<=n; i++)
		mem[i] =0;
	mem[0] = 1;

	for(int i=0; i<m; i++){
		for(int j = c[i]; j<=n; j++)
			mem[j] += mem[j-c[i]];
	}

	return mem[n];
}
