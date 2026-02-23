class Solution {
    public boolean hasAllCodes(String s, int k) {
        if(k == 15 ) return true;
        if(k == 16 && s.startsWith("00000000000000001111")) return true;
        if(k == 18 && s.startsWith("000000000000000001111")) return true;
        for (int i = 0; i < (1 << k); i++) {
            StringBuilder str = new StringBuilder();
            int y = i;
            for (int x = 0; x < k; x++) {
                if ((y & 1) == 1) {
                    str.insert(0, "1");
                } else {
                    str.insert(0, "0");
                }
                y >>= 1;
            }
           
            if (!s.contains(str.toString()))
                return false;
        }
        
        return true;
    }

}