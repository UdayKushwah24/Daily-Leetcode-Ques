package DailyLeetcodeQuestion;

import java.util.*;

public class q18_BasicCalc2_227 {
  /*   public static int calculate(String s) {
    String[] arr = s.split("[-*+/]");
    for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + ",");
    }
  
    System.out.println();
    System.out.println("++++++++++++++++=="); 
    String[] ar = s.split("[0-9]+");
    for (int i = 0; i < ar.length; i++) {
        System.out.print(ar[i] + ",");
    }
    System.out.println();
    System.out.println(arr.length);
    System.out.println(ar.length);
    return 2;
  } */
   
  

  public static int calculate(String s) {
      s = s.trim();
      if (s.length() == 0) {
          return 0;
      }
        ArrayList<String> list = new ArrayList<>();
        String[] arr = s.split("[-*+/]");
        String[] ar = s.split("[0-9]+");
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i].trim());
            if (i+1 < ar.length) {
                list.add(ar[i + 1].trim());
            }
        }

        System.out.println(list);
       
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < list.size(); i++) {
            stack.push(list.get(i));
        }
        
        System.out.println(stack);
        while (stack.size() > 1) {
            String n = stack.pop();
            String symbol = stack.pop();
            if (symbol.equals("+")) {
                String m = stack.pop();
                int c = Integer.parseInt(n) + Integer.parseInt(m);
                stack.push(c + "");
            }
            
            if (symbol.equals("-")) {
                String m = stack.pop();
                int c = Integer.parseInt(m) - Integer.parseInt(n);
                stack.push(c+"");
            }
            if (symbol.equals("*")) {
                String m = stack.pop();
                int c = Integer.parseInt(n) * Integer.parseInt(m);
                stack.push(c+"");
            }
            if (symbol.equals("/")) {
                String m = stack.pop();
                int c = Integer.parseInt(m) / Integer.parseInt(n);
                stack.push(c+"");
            }

        }
        return Integer.parseInt(stack.peek());

        
    }

    public static void main(String[] args) {
        String s = "1-1+1"; 
        // String s = "   3/2"; 
        // String s = "3+2*2";
        // String s = "34+4/5552*2";
        System.out.println(calculate(s));
    }
}