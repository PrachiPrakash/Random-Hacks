#include<iostream>
#include<unordered_map>
#include<stack>

using namespace std;

class node{
	public:
	int value ;
	node * l ;
	node * r ;
	node * random ;

	node(int val)
	{
		value = val;
		l = r = random = 0;
	}
};

int cloneBinaryTree(node* inputBT, node*& cloneBT ){
	
	if(0 == inputBT) return 0 ;
	cloneBT = new node(inputBT->value) ;

	unordered_map<node*, node*> nodeMapping ;

	stack<node*> stInput ;
	stack<node*> stClone ;
	stInput.push(inputBT) ;
	stClone.push(cloneBT) ;

	// create the clone tree
	while(!stInput.empty())
	{
		node * nI = stInput.top() ;
		stInput.pop() ;

		node * nC = stClone.top() ;
		stClone.pop() ;

		nodeMapping.insert(make_pair(nI, nC)) ;

		if(nI->l){
			stInput.push(nI->l) ;
			
			node* lnode = new node(nI->l->value) ;
			nC->l = lnode ;
			stClone.push(lnode) ;
		}

		if(nI->r){
			stInput.push(nI->r) ;

			node* rnode = new node(nI->r->value) ;
			nC->r = rnode ;
			stClone.push(rnode) ;
		}
	}

	// for random ptr
	for(unordered_map<node*, node*>::iterator it = nodeMapping.begin(); it != nodeMapping.end(); ++ it)
	{
		if(it->first->random)
			it->second->random = nodeMapping.at(it->first->random);
	}

	return 0 ;
}

void printInorder(node* n)
{
	if (n == NULL)
		return;
	     
	/* First recur on left sutree */
	printInorder(n->l);
		 
	/* then print data of Node and its random */
	cout << "[" << n->value << " ";
	if (n->random == NULL)
		cout << "NULL], ";
	else
		cout << n->random->value << "], ";
			     
	/* now recur on right subtree */
	printInorder(n->r);
}

int main(){

	node *tree = new node(1);
	tree->l = new node(2);
	tree->r = new node(3);
	tree->l->l = new node(4);
	tree->l->r = new node(5);
	tree->random = tree->l->r;
	tree->l->l->random = tree;
	tree->l->r->random = tree->r;

	cout << "Inorder traversal of original binary tree is: \n";
	printInorder(tree);
	     
	node *clone = 0 ;
	cloneBinaryTree(tree, clone);
	
	cout << "\n\nInorder traversal of cloned binary tree is: \n";
	printInorder(clone);

	return 0 ;
}








