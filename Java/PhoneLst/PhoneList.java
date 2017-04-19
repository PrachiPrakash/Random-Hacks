/**
*This Program is a solution to the PhoneLST problem of SPOJ.
*@author Prakash 
*/

import java.io.*;

class TrieNode
{
	boolean isLeaf;
	TrieNode sibbling[];

	public TrieNode()
	{
		isLeaf = false;
		sibbling = new TrieNode[10];
	}
}

class Trie
{
	private TrieNode head;

	public Trie()
	{
		head = new TrieNode();
	}

	public void clean()
	{
		head = null;
		head = new TrieNode();
	}

	public boolean addPhone(String phone)
	{
		TrieNode temp = head;
		int length = phone.length();
		boolean isVisited = false;

		for(int i=0; i<length; i++){

			if(temp.isLeaf)
				return false;
			if(temp.sibbling[phone.charAt(i)-48] == null){
				temp.sibbling[phone.charAt(i)-48] = new TrieNode();
				isVisited = true;
			}
			temp = temp.sibbling[phone.charAt(i)-48]; 
		}

		temp.isLeaf = true;
		if(isVisited)
			return true;
		else
			return false;
	}

}

public class PhoneList
{
	public static void main(String args[])
	{
		int t = 0, n = 0;
		BufferedReader br = null;
		String phone = "";
		boolean sucess = true;
		Trie list = new Trie();

		try{
			br = new BufferedReader(new InputStreamReader(System.in));
			t = Integer.parseInt(br.readLine());

			while(t-- > 0){
				n = Integer.parseInt(br.readLine());
				sucess = true;

				for(int i = 0; i<n; i++){

					phone = br.readLine();
					if(sucess)
						sucess = list.addPhone(phone);
				}

				if(sucess)
					System.out.println("YES");
				else
					System.out.println("NO");
				list.clean();
			}

		}

		catch(Exception ex){
			System.out.println(ex);
		}
	}
}