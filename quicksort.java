
public class quicksort {

	static void swap(int A[], int i, int j)
	{
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	static void quickSort(int A[], int left, int right)
	{
		if(left > right)
			return;
	
		int pos = left;
		int i;
		for(i=left+1; i<=right; i++)
			if(A[i] < A[left])
				swap(A, ++pos, i);
		swap(A, pos, left);

		quickSort(A, left, pos-1);
		quickSort(A, pos+1, right);
	}

	
	public static void main(String args[])
	{
		int A[] = new int[1000];
		int i;

		for(i=1000; i>=1; i--)
			A[1000-i] = i;
		
		quickSort(A, 0, 1000-1);
		
		for(i=0; i<1000; i++)
			System.out.print(A[i]+" ");
	}
}
