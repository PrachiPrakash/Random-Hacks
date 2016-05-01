#include <iostrteam>
#include <cstdlib>

using name
int getApples(int *,int);
int comparator(const void *,const void *);
int main()
{
  int n;
  int *ar;

  cin >> n;
  ar = new int[n];

  for(int i=0; i<n; i++)
    cin >> ar[i];
  getApples(ar,n);
  return 0;
}

int getApples(int *ar,int n)
{
  int i=0;
  int sum = 0;
  int part_sum = 0;
  int store_sum = 0;

  qsort(ar,n,sizeof(int),comparator);
  for(i=0; i<n; i++)
    sum += ar[i];
  i=0;
  while(sum % 3 != 0 && i< n){
      if(ar[i] % 3 == 0)
          part_sum += ar[i];
      else{
        store_sum += ar[i];
        sum -= ar[i];
        if(store_sum % 3 == 0){

            part_sum += store_sum;
            store_sum =0;
        }
      }

      i++;
  }
  if(part_sum > sum)
    return part_sum;
  else
    return sum;
}
int comparator(const void *t1,const void *t2)
{
    int *i = (int *)t1;
    int *j = (int *)t2;
    return *i - *j;
}
