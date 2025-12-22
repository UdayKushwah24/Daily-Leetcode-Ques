class Solution {
    public String arrangeWords(String text) {
        String[] arr=text.split(" ");
        Arrays.sort(arr,(a,b)->(
            a.length()-b.length()
        ));

        StringBuilder sb=new StringBuilder();

        sb.append(arr[0].substring(0,1).toUpperCase());
        sb.append(arr[0].substring(1).toLowerCase());
        sb.append(" ");
        for(int i=1;i<arr.length;i++){
            sb.append(arr[i].toLowerCase() + " ");
        }

        return sb.toString().trim();
    }
}