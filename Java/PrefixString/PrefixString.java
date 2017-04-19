public class PrefixString
{
	public static String getPrefixString(String s1, String s2)
	{
		int l1 = s1.length();
		int l2 = s2.length();

		int i =0; 
		int j = 0;

		String res = "";

		while(i < l1 && j < l2){
			if(s1.charAt(i) != s2.charAt(j))
				return res;
			res += s1.charAt(i);
			i++;
			j++;
		}

		return res;
	}

	public static String getMaxPrefix(String[] list, int lb, int ub)
	{
		if(ub == lb + 1)
			return getPrefixString(list[lb], list[lb+1]);
		else if(lb == ub)
			return list[lb];
		else{
			int mid = (lb+ub)/2;
			String left = getMaxPrefix(list,lb,mid);
			String right = getMaxPrefix(list, lb+1,ub);
			return getPrefixString(left,right);
		}
	}

	public static void main(String args[])
	{
		String list[] = {"geeksforgeeks", "geeks",
                    "geek", "geezer"};
		System.out.println(getMaxPrefix(list,0,list.length-1));
	}

}