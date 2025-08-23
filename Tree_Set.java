package Set;

import java.util.TreeSet;

public class Tree_Set {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(23);
        set.add(71);
        set.add(23);
        set.add(122);
        set.add(71);
        set.add(-1);
        System.out.println(set);
        // contains
        System.out.println(set.contains(23));
        System.out.println(set.contains(28));

        // remove
        System.out.println(set.remove(1));
        System.out.println(set.remove(200000));

        for (int val : set) {
            System.out.print(val + " ");
        }

    }
}
