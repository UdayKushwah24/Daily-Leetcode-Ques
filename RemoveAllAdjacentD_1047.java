package InfinityChampionsProgram.Day6;
import java.util.*;
public class RemoveAllAdjacentD_1047 {

    public String StringAfterStar(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == ch) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
            i++;
        }

        String ans = "";
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }
        return ans;
    }

    public String removeDuplicates(String s) {
        return StringAfterStar(s);
    }
}