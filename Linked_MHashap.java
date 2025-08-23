package Map;

import java.util.LinkedHashMap;

public class Linked_MHashap {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> hm = new LinkedHashMap<>();
        hm.put("Uday", 23);
        hm.put("Rohan", 25);
        hm.put("Shyam", 42);
        hm.put("Ram", 57);
        hm.put("Ram", 2007);
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

        //

    }
}
