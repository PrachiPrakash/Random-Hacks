public class PrevPermute
{
	public static String getPrevPermute(String s)
	{
		int i = s.length()-1;
		while(i > 0 && s.charAt(i-1) < s.charAt(i))
			i--;
		if(i == 0)	//last one no prev
			return s;

		int j = i;
		int min = i-1;
		while(j < s.length()){
			if(s.charAt(j) <  s.charAt(i-1))
				min = j;
			j++;
		}
		
		String res = s.substring(0,i-1) + s.charAt(min);
		String temp = s.substring(i, min) +s.charAt(i-1);

		System.out.println(min);
		

		if(min + 1 < s.length())
			temp += s.substring(min+1, s.length());
		System.out.println(res);
		System.out.println(temp);

		return res + new StringBuffer(temp).reverse().toString();

	}
	public static void main(String args[])
	{
		String s = "4123";

		System.out.println(getPrevPermute(s));
	}
}