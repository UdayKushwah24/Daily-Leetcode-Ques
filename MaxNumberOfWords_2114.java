package Map;
 
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxNumberOfWords_2114 {
    public static int mostWordsFound(String[] sentences) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < sentences.length; i++) {
            int len = sentences[i].split(" ").length;
            pq.add(len);
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        String[] sentences = { "alice and bob love leetcode", "i think so too", "this is great thanks very much" };
        System.out.println(mostWordsFound(sentences));
    }
}