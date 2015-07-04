/**
**this program find the longest palindromic subsequence of a String
**using the  algorithm for finding for longest common subsequence.
**@author Prachi Prakash
*/
#include <iostream>
#include <cstdlib>
#include <string>
#define MAX(a,b) (a)>(b)?(a):(b)

using namespace std;

string ComputeLCS(string&);
string GetLCP(string&,string&,int**);
string reverse(string&);

int main()
{
    string s;
    
    cin >> s;
    cout << ComputeLCS(s)<<endl;
    return 0;
}

string ComputeLCS(string& s)
{
     int len = s.length();
     string sr = reverse(s);
     
     int **mem = new int*[len+1];
     
     for(int i=0; i<=len; i++)
             mem[i] = new int[len+1];
     
     for(int i=0; i<=len; i++){
             mem[i][0] = 0;
             mem[0][i] = 0;
     }
     
     for(int i=1; i<=len; i++){
             for(int j=1; j<=len; j++){
                     
                     if (s[i-1] == sr[j-1])
                        mem[i][j] = mem[i-1][j-1]+1;
                     else
                         mem[i][j] = MAX(mem[i][j-1],mem[i-1][j]);       
             }
     }
     return GetLCP(s,sr,mem);
                          
}

string GetLCP(string& s, string& sr,int **mem)
{
       int i,j;
       i=j=s.length();
       string temp;
       while(i>0 && j>0){
                 if(s[i-1] == sr[j-1]){
                         temp = s[i-1] + temp;
                         i = i-1;
                         j = j-1;
                 }
                 else if(mem[i-1][j] > mem[i][j-1])
                         i--;
                 else
                         j--;
       }
       
       return temp;
}

string reverse(string& s)
{
       string temp;
       
       for(int i = s.length()-1; i>=0; i--)
               temp.push_back(s[i]);
       
       return temp;
       
       
}
