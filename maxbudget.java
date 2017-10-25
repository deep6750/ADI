import java.util.Scanner;

public class maxbudget {
	static void swap(float A[], int i, int j)
	{
		float temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	static void quickSort(float A[], int left, int right)
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
		Scanner in = new Scanner(System.in);
		int N;
		float budget;
		System.out.println("Enter array size: ");
		N = in.nextInt();

		float A[] = new float[N];
		int i;
		System.out.println("Enter array: ");
		for(i = 0; i < N; i++)
			A[i] = in.nextFloat();

		System.out.println("Enter budget: ");
		budget = in.nextFloat();

		quickSort(A, 0, N-1);

		for(i=0; i<N; i++)
			if((A[i] * (N-i)) > budget)
			{
				System.out.println("Max limit of stipend per person: "+budget/(N-i));
				break;
			}
			else{
				budget = budget - A[i];
			}
	}
	

}