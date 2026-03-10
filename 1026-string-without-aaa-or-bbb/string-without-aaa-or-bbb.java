class Solution {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        
        while(a > 0 || b > 0) {
            if(a > b) {
                if(a-- > 0) sb.append("a");
                if(a-- > 0) sb.append("a");
                if(b-- > 0) sb.append("b");
            } 
            if(b > a) {
                if(b-- > 0) sb.append("b");
                if(b-- > 0) sb.append("b");
                if(a-- > 0) sb.append("a");
            }
            if(a == b) {
                if(a-- > 0) sb.append("a");
                if(b-- > 0) sb.append("b");
            }
        }
        return sb.toString();
    }
}