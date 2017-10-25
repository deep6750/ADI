import java.util.*;
import java.io.*;

public class strrev{


    public static void main(String []args)
    {
        Stack<Character> stack = new Stack<Character>();
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        str = str.toLowerCase();
        String []words = str.split(" ");
        String reverse = "";
       for(String w: words)
       {
           StringBuilder st = new StringBuilder(w);
           st.reverse();
           reverse += st.toString()+" ";
           
       }
       String [] new_words = reverse.split(" ");
       String final_word="";
       for(String w:new_words)
       {
          final_word +=  Character.toUpperCase(w.charAt(0))+w.substring(1)+" ";
       }
        System.out.println(final_word);
    }
}
