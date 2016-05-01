/**
  *This program demonstrates the recursive solution to the 
  *insertion sort problem.
  *complkexity:T(n) = T(n-1)+O(n)+c
  *@author Prachi Prakash
  */

#include <iostream>

using namespace std;

void sort(int *,int);

int main()
{
	int a[] = {5,4,3,2,1};
	sort(a,4);
	for(int i=0; i<5; i++)
		cout <<a[i]<<" ";

	cout << endl;

	return 0;
}

void sort(int *vec,int n)
{
	int j=0;
	int key =0;

	if(n == 0)
		return;
	else{
		sort(vec,n-1);
		j = n-1;
		key = vec[n];

		while(j>=0 && vec[j] > key){
			vec[j+1] = vec[j];
			j--;
		}
		vec[j+1] = key;

	}
}
