/* class Solution {
    public boolean isLongPressedName(String name, String typed) {
        if(name.charAt(0) != typed.charAt(0) || name.charAt(name.length()-1) != typed.charAt(typed.length() - 1) ) return false;
        LinkedHashMap<Character, Integer> n = new LinkedHashMap<>();
        LinkedHashMap<Character, Integer> t = new LinkedHashMap<>();
        for(int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if(!n.containsKey(ch)) {
                n.put(ch, 1);
            } else {
                n.put(ch, n.get(ch) + 1);
            }
        }
        for(int i = 0; i < typed.length(); i++) {
            char ch = typed.charAt(i);
            if(!t.containsKey(ch)) {
                t.put(ch, 1);
            } else {
                t.put(ch, t.get(ch) + 1);
            }
        }
        if(n.size() != t.size()) return false;
        for(char ch : n.keySet()) {
            if(!t.containsKey(ch)) return false;
            if(n.get(ch) > t.get(ch)) return false;
             
        }
        return true;
    }
} */



class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }
}
