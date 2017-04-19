import java.io.*;
import java.util.*;


public class BeautifulWord
{
	public static final Set<Character> VOWEL;

	static{
		VOWEL = new HashSet<Character>();
		VOWEL.add('a');
		VOWEL.add('e');
		VOWEL.add('i');
		VOWEL.add('o');
		VOWEL.add('u');
		VOWEL.add('y');
	}
	public static void main(String ...args)
	{
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String input = br.readLine();

			input = input.toLowerCase();
			int len = input.length();
			char prev = input.charAt(0);
			char curr = 0;

			for(int i=1; i<len; i++){
				curr = input.charAt(i);

				if(curr == prev || (VOWEL.contains(prev) && VOWEL.contains(curr))){
					System.out.println("NO");
					return;
				} 
				prev = curr;
			}

			System.out.println("Yes");
		}
		catch(IOException ex){
			System.out.println(ex);
		}
	}
}