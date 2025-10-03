package InfinityChampionsProgram.Day6;

public class CheckBalancedString_3340 {
    public static boolean isBalanced(String num) {
        int odd = 0;
        int even = 0;
        for (int i = 0; i < num.length(); i++) {
            odd += num.charAt(i) - '0';
            i++;
            if (i < num.length()) {
                even += num.charAt(i) - '0';
            }
        }
        if (odd == even) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        
    }
}
