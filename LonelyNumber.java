import java.util.Scanner;

public class LonelyNumber {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int N, lonely = 0, i, j;
		System.out.println("Enter size of array");
		N = in.nextInt();

		int arr[] = new int[N];
		System.out.println("Enter all numbers in pairs of 3 except one number which occurs once: ");
		for(i = 0; i < N; i++)
			arr[i] = in.nextInt();

		System.out.println("Your array: ");
		for(i = 0; i < N; i++)
			System.out.print(arr[i] + " ");

		// FINDING LONELY NUMBER: 
		
		// Storing bits: 
		int bits[] = new int[32];
		for(i = 0; i < N; i++)
			for(j = 0; j < 32; j++)
				bits[j] += ((arr[i] >> j) & 1);

		// Constructing the lonely number:
		lonely = 0;
		for(j = 0; j < 32; j++)
			if(bits[j] % 3 != 0)     // the triplet numbers will have bits occurring thrice, except that one number occurring once, whose 1 bit positions can be determined via the bits array
				lonely += Math.pow(2, j);
		
		System.out.println("\nLonely number: " + lonely);
	}
}
