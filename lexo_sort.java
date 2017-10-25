import java.util.*;

public class lexo_sort{

    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        String str[] = new String[5];
        for(int i = 0; i < 5; i++)
        {
            str[i]=in.nextLine();
        }
        for(int i = 0; i < 5;i++)
        {
            for(int j = i+1; j < 5;j++)
            {
                if(str[j].compareTo(str[i])<0)
                {
                    String temp = str[i];
                    str[i] = str[j];
                    str[j] = temp;
                }
                
            }
        }
        System.out.println("After Sorting :");
        for(String w : str)
        {
            System.out.println(w);
        }
    }
}
