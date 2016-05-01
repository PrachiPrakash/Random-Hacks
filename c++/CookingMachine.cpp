#include <iostream>

using namespace std;

int ComputeMinSteps(int,int);

int main()
{
    int t,s,d;
    cin >> t;
    while(t--){
      cin >>s >>d;
      cout << ComputeMinSteps(s,d)<<endl;
    }
    return 0;
}

int ComputeMinSteps(int s,int d)
{
    int steps =0;
    if (s == 0)
      return 0;

    while(s != d){
        if((s & (s-1)) == 0 && s<d)
          s = s*2;
        else if((s & (s-1)) == 0 && s>d)
          s = s/2;
        else if(s%2 == 0)
          s = s/2;
        else
          s = (s-1)/2;
        steps++;
    }

    return steps;

}
