import java.util.*;
import java.lang.*;
import java.io.*;

class four {
	public static void main (String[] args) {
	    Scanner in = new Scanner(System.in);
	    int t,n,x;
	    t = in.nextInt();
	    int array[];
	    int count = 0;
	    int c = 0;
	    int unique[];
	    unique = new int[10000];
	    for(int i = 0; i < t; i++)
	    {
	        n = in.nextInt();
	        
	        array = new int[n];
	        for(int p = 0; p < n;p++)
	        {
	            array[p]=in.nextInt();
	        }
		x = in.nextInt();
		Arrays.sort(array);
		c = n;
		for(int d = 0; d < n; d++)
		{
		    if(array[d] != array[d+1])
		    {
                          unique[c++] = array[d];
		    }
		}
		
		/*int m = 0;
		for(int d = 0; d < n; d++)
		{
			if(array[d] != array[d+1])
			{
				if(m < c)
				{
					unique[m] = array[d];
					m++;
				}

				
			}
		}
	        */
	        for(int j =0; j < c; j++)
	        {
	            for(int k = j+1; k < c; k++)
	            {
	                if(unique[k]+unique[j] == x)
	                {
	                    count++;
	                }
	            }
	        }
	    }
	    System.out.println(count);
	    
		
	}
}
