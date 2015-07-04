/**
*intersection of two binary seach tree
*@function NewNode(int):creates binary tree node takin the key as input
*@function insert(Node *r,Node *nw):inserts the new node into binary tree r
*@function PrintIntersect:prints the intersection of two bst
*/
#include <iostream>
#include <stack>

using namespace std;
struct Node
{
	int data;
	Node *left,*right;
};

void PrintIntersect(Node *,Node *);
Node *insert(Node *,Node *);
Node *NewNode(int);

int main()
{
	Node *root1 = NULL;
	Node *root2 = NULL;
	
	root1 = insert(root1,NewNode(10));
	root1 = insert(root1,NewNode(5));
	root1 = insert(root1,NewNode(12));
	root1 = insert(root1,NewNode(7));
	root1 = insert(root1,NewNode(6));
	
	root2 = insert(root2,NewNode(6));
	root2 = insert(root2,NewNode(12));
	root2 = insert(root2,NewNode(13));
	
	PrintIntersect(root1,root2);
	
	return 0;
}
void PrintIntersect(Node *root1,Node *root2)
{
	stack<Node*> s1;
	stack<Node*> s2;
	
	Node *curr1,*curr2;
	
	while(root1){
		s1.push(root1);
		root1 = root1->left;
	}
	
	while(root2){
		s2.push(root2);
		root2 = root2->left;
	}
	
	while(!s1.empty() && !s2.empty()){
		
		curr1 = s1.top();
		curr2 = s2.top();
		
		if(curr1->data == curr2->data){
		
			s1.pop();
			curr1 = curr1->right;
			while(curr1){
				s1.push(curr1);
				curr1 = curr1->left;
			}
			cout << curr2->data<<" ";
			
			s2.pop();
			curr2 = curr2->right;
			while(curr2){
				s2.push(curr2);
				curr2 = curr2->left;
			}
		}
		else if(curr1 -> data < curr2->data){
			s1.pop();
			curr1 = curr1->right;
			while(curr1){
				s1.push(curr1);
				curr1 = curr1->left;
			}
		}
		
		else{
			s2.pop();
			curr2 = curr2->right;
			while(curr2){
				s2.push(curr2);
				curr2 = curr2->left;	
			}
		}
	}
	
}

Node *insert(Node *root,Node *nw)
{
	if(!root)
		return nw;
	else if(nw->data > root->data)
		root->right = insert(root->right,nw);
	else
		root->left = insert(root->left,nw);
	return root;
}

Node *NewNode(int data)
{
	Node *nw = new Node;
	
	nw->data = data;
	nw->left = nw->right = NULL;
	
	return nw;
}
