class Solution {
    public   boolean checkDuplicate(String str) {
        HashSet<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            set.add(ch);
        }
        return set.size() == str.length();
    }

    public   int SetBit(String str) {
        int num = 0;
        for (char ch : str.toCharArray()) {
            num |= (1 << (ch - 'a'));
        }
        return num;
    }

    public   int maxLength(List<String> arr) {
        List<String> list = new ArrayList<>();
        for (String str : arr) {
            if (checkDuplicate(str)) {
                list.add(str);
            }
        }
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = SetBit(list.get(i));
        }
        
        int temp = 0;
        solve(0, temp, array);
        
        return result;
    }

    public   int countSetbit(int n) {
        int set = 0;
        while(n > 0) {
            set++;
            n = (n & (n-1));
        }
        return set;
    }
    
      int result = 0;
    private   void solve(int idx, int temp, int[] arr) {
        // result = Math.max(result, Integer.bitCount(temp));
        result = Math.max(result, countSetbit(temp));
        for (int i = idx; i < arr.length; i++) {
            if ((temp & arr[i]) == 0) {
                solve(i + 1, temp | arr[i], arr);
            }
        }
    }
}