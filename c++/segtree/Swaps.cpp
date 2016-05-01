/**
  *This problem solves the Swaps problem of 
  *SPOJ.
  *@author Prachi Prakash
  */
#include <iostream>
using namespace std;

struct SegTreeNode{
	int count;
	int lb;
	int ub;
	SegTreeNode *left, *right;
};

SegmentTree *ConstructTree(int *,int,int);
int merge(int *,int,int,int);
SegmentTree *getNode
int main
