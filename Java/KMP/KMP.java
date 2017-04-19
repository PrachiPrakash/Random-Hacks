public class KMP
{
	public static int[] patternProcess(String pattern)
	{
		int len = pattern.length();
		int pre[] = new int[len];
		int j = 0;
		for(int i =1; i<len; i++){
			while(j-1 >= 0 && pattern.charAt(j) != pattern.charAt(i))
				j = pre[j-1];
			if(pattern.charAt(j) == pattern.charAt(i)){
				pre[i] = j+1;
				j++;
			}
		}

		return pre;
	}

	public static void check(String pattern,String text)
	{
		int len = text.length();
		int i = 0;
		int j =0;
		int lps[] = patternProcess(pattern);

		while(i < len){
			while(j-1 >=0 && text.charAt(i) != pattern.charAt(j))
				j = lps[j-1];
			if(pattern.charAt(j) == text.charAt(i))
				j++;
			if(j == pattern.length()){
				System.out.println("found in " +( i-(pattern.length())+1));
				j = 0;
				continue;
			}
			i++;
			
		}
	}

	public static void main(String args[])
	{
		String pattern = "aba";
		String text = "aaaababa";
		check(pattern, text);
		
	}
}