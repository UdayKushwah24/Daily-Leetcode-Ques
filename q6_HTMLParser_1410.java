package DailyLeetcodeQuestion;

import java.util.*;

public class q6_HTMLParser_1410 {
    public static String entityParser(String text) {
        List<String> ll = new ArrayList<>();
        // ll.add("&quot;");
        // ll.add("&apos;");
        // ll.add("&amp;");
        // ll.add("&gt;");
        // ll.add("&lt;");
        // ll.add("&frasl;");

        Map<String, String> map = new HashMap<>();
        map.put("&quot;","\\\"");
        map.put("&apos;", "\\'");
        map.put("&amp;", "\\&");
        map.put("&gt;", "\\>");
        map.put("&lt;", "\\<");
        map.put("&frasl;", "\\/");
        ll.add("\\\"");
        ll.add("\\'");
        ll.add( "\\&");
        ll.add( ">");
        ll.add( "<");
        ll.add("/");
        System.out.println(map);

        System.out.println(ll);

        String[] arr = text.split(" ");
        for (int i = 0; i < arr.length; i++) {
            
            System.out.print(arr[i]+" ");
        }
        return "";

        
    }
    public static void main(String[] args) {
        // String text = "&amp; is an HTML entity but &ambassador; is not.";
        String text = "and I quote: &quot;...&quot;";
        System.out.println(entityParser(text));
    }
}
