#include <iostream>

using namespace std;

int CountSort(int *,int);

int main()
{
	int n;
	cin >> n;

	int *a = new int[n];

	for(int i=0; i<n; i++)
		cin >> a[i];
	
	cout << CountSort(a,n)<<endl;
	return 0;
}

int CountSort(int *a,int n)
{
	int count =0;
	for(int i=1; i<n; i++){
		int temp = a[i];
		int j = i-1;
		bool flag = false;
		while(j>=0 && a[j]>temp){
			flag = true;
			count++;
			a[j+1] = a[j];
			j--;
		}
		if(flag){
			a[j+1] = temp;
		}
	
	}
	return count;
}

