import java.io.*;

public class FileRead
{
	public static void main(String args[])throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("fuck.txt"));
		String temp = null;
		while((temp = br.readLine()) != null)
			System.out.println(temp);
	}
}