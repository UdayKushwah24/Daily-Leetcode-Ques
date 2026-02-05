/* class Solution {
    public String longestCommonPrefix(String[] strs) {
       String first = strs[0];
		String ans = "";
		for (int i = 0; i < first.length(); i++) {
			String subStr = first.substring(0, i + 1);
			boolean allMatch = true;
			for (int j = 0; j < strs.length; j++) {
				if (!strs[j].startsWith(subStr)) {
					allMatch = false;
					break;
				}
			}
			if (allMatch) {
				ans = subStr;
			} else {
				break;
			}
		}
		return ans;
    }
} */




/* 

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String first = strs[0];
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < first.length(); i++) {
			char ch = first.charAt(i);
			boolean allMatch = true;
			for (int j = 0; j < strs.length; j++) {
				if (  i >= strs[j].length() || strs[j].charAt(i) != ch) {
					allMatch = false;
					break;
				}
			}
			if (allMatch) {
				ans.append(ch);
			} else {
				break;
			}
		}
		return ans.toString();
    }
} */


class Solution {

    // class Node {
    //     char ch;
    //     boolean isTerminal;
    //     HashMap<Character, Node> child;
    //     public Node(char ch) {
    //         this.ch = ch;
    //         child = new HashMap<>();
    //     }
    // }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
          Arrays.sort(strs);
         String f = strs[0];
         String s = strs[strs.length-1];
         int ans = 0;
         int i = 0, j = 0;
         StringBuilder sb = new StringBuilder();
         while(i < f.length() && j < s.length()) {
            if(f.charAt(i) == s.charAt(j)){
                sb.append(""+f.charAt(i));
            } else {
                break;
            }
                i++; j++;
         }
         return sb.toString();
    }
}

































