
/*
 *   ABSTRACT SORT CLASS :
 */

abstract class sortAbstractClass {
	
	void swap(int arr[], int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	void print(int arr[]) {
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}
	
	abstract void mySort(int arr[]);

};


/*
 *   SELECTION SORT CLASS INHERITS THE ABSTRACT SORT CLASS AS A BASE :
 */

class SelSort extends sortAbstractClass {
	
	@Override
	void print(int arr[]) {		// overridden print function
		System.out.print("Hola! The arr[] is: ");
		super.print(arr);
	}
	
	void mySort(int arr[]) {	// defined abstract mySort function
		int i, j, min;
		for(i = 0; i < arr.length - 1; i++) {
			min = i;
			for(j = i; j < arr.length; j++)
				if(arr[j] < arr[min])
					min = j;
			
			swap(arr, i, min);
		}
	}

};


/* 
 * MAIN CLASS
 */

public class mySort {
	
	public static void main(String args[]) {
		
		SelSort sortObj = new SelSort();
		
		/*
		 * OR:         sortAbstractClass sortObj = new SelSort();
		 * BUT NOT:    mySort sortObj = new SelSort(); <-- Error! As mySort is not parent of it.
		 */
		
		int arr[] = new int[] {1, 4, 3, 10, -90, 3, 0, 1, 33};
		
		System.out.println("\n\nOLD: ");
		sortObj.print(arr);

		sortObj.mySort(arr); // sort function call

		System.out.println("\n\nNEW: ");
		sortObj.print(arr);
	}

};