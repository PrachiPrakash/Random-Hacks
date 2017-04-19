import java.util.*;
class TreeNode
{
	int key,hd;
	TreeNode left,right;

	public TreeNode(int key)
	{
		this.key = key;
		hd =0;
	}
}
class Tree
{
	TreeNode root;
	public Tree()
	{
		root = null;
	}
	public TreeMap<Integer, TreeNode> getBottomView()
	{
		TreeMap<Integer,TreeNode> ob =
										new TreeMap<Integer,TreeNode>();

		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		int size = 1;
		while(!q.isEmpty()){
			int currSize = 0;

			for(int i=1; i<=size; i++){
				TreeNode t = q.pollFirst();
				ob.put(t.hd, t);
				if(t.left != null){
					currSize++;
					t.left.hd = t.hd-1;
					q.add(t.left);
				}
				if(t.right != null){
					currSize++;
					t.right.hd = t.hd+1;
					q.add(t.right);
				}
			}
			size = currSize;
		}		
		return ob;
	}

	
}
public class BottomView
{
	public static void main(String args[])
	{
		Tree tree = new Tree();
		tree.root = new TreeNode(20);

		tree.root.left = new TreeNode(8);
        tree.root.right = new TreeNode(22);
        tree.root.left.left = new TreeNode(5);
        tree.root.left.right = new TreeNode(3);
        tree.root.right.left = new TreeNode(4);
        tree.root.right.right = new TreeNode(25);
        tree.root.left.right.left = new TreeNode(10);
        tree.root.left.right.right = new TreeNode(14);

        TreeMap<Integer, TreeNode> ob = tree.getBottomView();
        Iterator<Map.Entry<Integer,TreeNode>> it = ob.entrySet().iterator();

        while(it.hasNext()){
        	Map.Entry<Integer,TreeNode> e = it.next();
        	System.out.println(e.getValue().key);
        }

	}
}