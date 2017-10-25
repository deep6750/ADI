import java.util.*;
public class Evaluate {
    public static void main(String[] args) { 
        Stack<String> ops  = new Stack<String>();
        Stack<Integer> vals = new Stack<Integer>();
        

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if      (s.equals("("))               ;
            else if (s.equals("+"))    ops.push(s);
            else if (s.equals("-"))    ops.push(s);
            else if (s.equals("*"))    ops.push(s);
            else if (s.equals("/"))    ops.push(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                Integer v = vals.pop();
                if      (op.equals("+"))    v = vals.pop() + v;
                else if (op.equals("-"))    v = vals.pop() - v;
                else if (op.equals("*"))    v = vals.pop() * v;
                else if (op.equals("/"))    v = vals.pop() / v;
                vals.push(v);
            }
            else vals.push(Integer.parseInt(s));
        }
        StdOut.println(vals.pop());
    }
}
