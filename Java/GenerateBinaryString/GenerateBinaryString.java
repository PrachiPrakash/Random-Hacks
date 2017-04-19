public class GenerateBinaryString
{
	public static void generatePermutation(String in, String res, int i)
	{
		if(i > in.length())
			return;
		else if(i == in.length())
			System.out.println(res);
		else if(in.charAt(i) != '?')
			generatePermutation(in,res+in.charAt(i),i+1);
		else{
			generatePermutation(in,res+'0',i+1);
			generatePermutation(in, res+'1',i+1);
		}
	}

	public static void main(String args[])
	{
		String s = "1??0?101";
		generatePermutation(s,"",0);
	}
}