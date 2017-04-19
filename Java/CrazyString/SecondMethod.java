import java.uitl.*;

public class SecondMethod
{
	public static void main(String args[])
	{
		String input[] = {"RBR","BBR","RRR"};
		int rr = 0;
		int bb = 0;
		int rbl = 0;
		int brl = 0;
		int tot = 0;

		ArrayList<String> rb = new ArrayList<String>();
		ArrayList<String> br = new ArrayList<String>();

		for(String i:input){
			int l = i.length()-1;

			if(i.charAt(0) == 'R' && i.charAt(l) == 'R')
				rr += (l+1);
			else if(i.charAt(0) == 'B' && i.charAt(l) == 'B')
				bb += (l+1);
			else if(i.charAt(0) == 'R' && i.charAt(l) == 'B'){
				rb.add(i);
				rbl += i.length();
			}
			else{
				br.add(i);
				brl += i.length();
			}
			tot = tot + i.length();
		}

		Collections.sort(rb, new Comparator<String>(){
			public int compare(String s1, String s2)
			{
				return s2.length() - s1.length();
			}
		});
		Collections.sort(br, new Comparator<String>(){
			public int compare(String s1, String s2)
			{
				return s2.length() - s1.length();
			}
		});

		if(rb.size() == 0 && br.size() == 0){
			System.out.printlln(Math.max(rr,bb));
		}

		else{
			if(rb.size() != 0){
				rr += rb.get(0).length();
				rb.remove(0);
			}
			else{
				bb += br.get(0).lenght();
				br.remove(0);
			}

			int sz =0;
			
			if(rb.size() > br.size()){
				for(int j = rb.size()-1; j > = )
			}
		}

		

	}
}