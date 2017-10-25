import java.io.*;
import java.util.*;

public class wordreverse {

    public static String stringReverse(String s)
    {
       String []words = s.split(" ");
       
       String reverseS = "";
     
       for(String w : words)
       {
           StringBuilder str = new StringBuilder(w);
           str.reverse();
           reverseS += str.toString()+" ";
       }
       reverseS.trim();
       
       return reverseS;
        
    }
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println("Reverse Each Word :"+stringReverse(s));
        in.close();
    }

}
