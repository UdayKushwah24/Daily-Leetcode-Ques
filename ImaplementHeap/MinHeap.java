package Heap.ImaplementHeap;

import java.util.*;
public class MinHeap {
    private ArrayList<Integer> ll = new ArrayList<>();

    public void add(int item) {
        ll.add(item);
        unheapify(ll.size() - 1);
    }

    private void unheapify(int ci) {  // ci -> child index
        int pi = (ci - 1) / 2;
        if (ll.get(pi) > ll.get(ci)) {
            swap(pi, ci);
            unheapify(pi);
        }
    }

    private void swap(int pi, int ci) { // pi -> parent index
        int pith = ll.get(pi);
        int cith = ll.get(ci);
        ll.set(pi, cith);
        ll.set(ci, pith);
    }
    
    public int remove() {
        // return ll.remove(0);  // TC : O(n)

        swap(0, ll.size() - 1);
        int rv_val = ll.remove(ll.size() - 1);
        downHeapify(0);
        return rv_val;
    }
    
    private void downHeapify(int pi) {
        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;
        int mini = pi;
        if (lci < ll.size() && ll.get(mini) > ll.get(lci)) {
            mini = lci;
        }
        if (rci < ll.size() && ll.get(mini) > ll.get(rci)) {
            mini = rci;
        }
        if (mini != pi) {
            swap(mini, pi);
            downHeapify(mini);
        }
    }

    public int get() {
        return ll.get(0);
    }

    public int size() {
        return ll.size();
    }

    public void Display() {
        System.out.println(ll);
    }

  
}
