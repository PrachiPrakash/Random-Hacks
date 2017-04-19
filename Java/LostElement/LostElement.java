public class LostElement
{
	public static int lostElement(int list1[], int list2[])
	{
		int le = list1[0];
		for(int i=1; i<list1.length;i++)
			le ^= list1[i];
		for(int j =0; j<list2.length; j++)
			le ^= list2[j];
		return le;
	}

	public static void main(String args[])
	{
		int arr1[] = {1,4,5,7,9};
		int arr2[] = {4,5,7,9};

		System.out.println(lostElement(arr1,arr2));
	}
}
