class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        int n = words.length;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            String str = words[i];
            for(int j = 0; j < str.length(); j++) {
                sum += weights[str.charAt(j)-'a'];
            }
            sum = sum % 26;
            sum = 26-sum-1; 
            sb.append((char)(97+sum));
        }
        return sb.toString();

    }
}