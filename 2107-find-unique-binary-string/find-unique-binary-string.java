/* class Solution {

    public void Generate(List<String> ll, int n, String s) {

        if (n == 0) {
            ll.add(s);
            return;
        }

        Generate(ll, n - 1, s + "0");
        Generate(ll, n - 1, s + "1");
    }

    public String findDifferentBinaryString(String[] nums) {
        List<String> ll = new ArrayList<>();
        Generate(ll, nums[0].length(), "");

        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        String ans = "";
        for (int i = 0; i < ll.size(); i++) {
            if (!list.contains(ll.get(i))) {
                ans = ll.get(i);
                break;
            }
        }
        return ans;
    }
} */

class Solution {

    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            // Flip the ith bit of ith string
            ans.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return ans.toString();
    }

}