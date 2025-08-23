package Map;

import java.util.*;

public class Hash_Map {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Uday", 23);
        hm.put("Rohan", 25);
        hm.put("Shyam", 42);
        hm.put("Ram", 57);
        hm.put("Ram", 2007);
        hm.put(null, null);
        System.out.println(hm);

        // add , remove, set, contain, display, get

        // contains
        System.out.println(hm.containsKey("Uday"));
        System.out.println(hm.containsKey("hello"));

        // get
        System.out.println(hm.get("Uday"));
        System.out.println(hm.get("hello"));

        // remove
        System.out.println();
        System.out.println(hm.remove("Uday"));
        System.out.println(hm.remove("hello"));
        System.out.println(hm);

        // size
        System.out.println(hm.size());

        // print
        Set<String> set = hm.keySet();
        for (String key : set) {
            System.out.println(key + " "+hm.get(key));
        }
    }
}
