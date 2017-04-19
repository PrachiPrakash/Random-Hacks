public class GenerateParenthesis
{
	public static void printParenthesis(String input, String res, int i)
	{
		if(i == input.length()){
			System.out.println(res);
			return;
		}
		res = res + "(";

		for(int j = i; j<input.length(); j++){
			res += input.charAt(j);
			printParenthesis(input,res+")",j+1);
		}
	}

	public static void main(String ...args)
	{
		String s = "abcd";
		printParenthesis(s, "", 0);
	}
}