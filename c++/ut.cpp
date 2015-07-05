/**
 *This Program solves the Utropian tree problem
 *of  Hackerrank which is under the easy category
 *@author Prachi Prakash
 *@link https://www.hackerrank.com/challenges/utopian-tree
 */
#include <iostream>
using namespace std;

int mem[61];

void Computehieght()
{
    mem[0] = 1;
    for(int i=1; i<=60; i++){
        if(i%2 != 0)
            mem[i] = 2*mem[i-1];
        else
            mem[i] = mem[i-1]+1;
}
int height(int n) 
{
    return mem[n];
}
int main() 
{
    int T;
    cin >> T;
    Computehieght();
    while (T--) {
        int n;
        cin >> n;
        cout << height(n) << endl;
    }
}
