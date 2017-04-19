public class IsSequence
{
	public static boolean check(String s,String s2, int i, int j)
	{
		if(i >= s.length() && j >= s2.length())
			return true;
		if(j == s2.length()-1 && s.charAt(i) == s2.charAt(j))
			return true;
		else if(j == s2.length()-1 && i == s.length()-1)
			return false;
		else if(s.charAt(i) == s2.charAt(j))
			return check(s,s2,i+1,j+1);
		else
			return check(s,s2,i+1,j);
	}

	public static void main(String args[])
	{
		String s1 = "ahbgdc";
		String s2 = "abh";

		System.out.println(check(s1,s2,0,0));
		System.out.println(isSequence(s2,s1));
	}

	public static boolean isSequence(String s, String t)
	{
		int l1 = s.length();
		int l2 = t.length();

		int i=0,j=0;

		while(i < l2){
			if(t.charAt(i) == s.charAt(j) && j == l1-1)
				return true;
			else if(t.charAt(i) == s.charAt(j)){
				i++;
				j++;
			}
			else
				i++;
		}
		return false;
	}
}