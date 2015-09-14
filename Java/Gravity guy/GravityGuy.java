import java.io.*;

class GravityGuy
{
		public static void main(String args[])throws IOException
		{
			int testCase =0;
			String lanes[] = new String[2];
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			testCase = Integer.parseInt(br.readLine());
			
			while(testCase-- > 0){
				
				lanes[0] = br.readLine();
				lanes[1] = br.readLine();
				computeSteps(lanes);
			}
		
		}
		
		public static void computeSteps(String lanes[])
		{
			int i=0;
			int len = lanes[0].length();
			int lane =0;
			int gs = 0;
			
			if(lanes[0].charAt(i) == '#' && lanes[1].charAt(i) == '#'){
				System.out.println("No");
				return;
			}
			
			lane = getLane(lanes[0],lanes[1]);
			
			i++;
			
			while(i < len){
				if(lanes[lane].charAt(i) == '.')
					i++;
				else if((i+1 < len) && lanes[(lane+1)%2].charAt(i+1) == '.'){
					i++;
					gs++;
					lane = (lane + 1)%2;
				}
				else if(lanes[(lane+1)%2].charAt(i) == '.'){
					gs++;
					lane = (lane + 1)%2;
				}
				else
					break;
			}
			
			if(i != len)
				System.out.println("No");
				
			else{
				System.out.println("Yes");
				System.out.println(gs);
			}
			
		}
		
		public static int getLane(String l1,String l2)
		{
				int i=0;
				int len = l1.length();
				
				while(i < len && l1.charAt(i) != '#' && l2.charAt(i) != '#')
					i++;
				if(i == len)
					return 0;
				else if(l2.charAt(i) == '#')
					return 0;
				else
					return 1;
		
		}
}
