package InfinityChampionsProgram.Day6;


import java.util.*;
public class RemoveStarsSting_2390 {

    public static String StringAfterStar(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) == '*') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s.charAt(i));
            }
            i++;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0,stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println(StringAfterStar(s));
    }
}
