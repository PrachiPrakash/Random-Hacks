#include <iostream>
#include <cstdio>


using namespace std;

long long GetDifference(int);

int main()
{
	int t,n;

	cin >> t;

	while(t--){
		cin >> n;
		printf("%lld\n",GetDifference(n));
	}
	
	return 0;
}

long long GetDifference(int n)
{
	return (n*n*(n+1)*(n+1)/4)-(n*(n+1)*(2*n+1)/6);
}
