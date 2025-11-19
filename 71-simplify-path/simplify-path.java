/* class Solution {
    public String simplifyPath(String path) {
        return SimplifyPath(path);
    }

    public   String SimplifyPath(String path) {
        String[] arr = path.split("/+");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == "" || arr[i].equals(".")) {
                continue;
            }
         
            if (!stack.isEmpty() && arr[i].equals("..")) {
                stack.pop();
                 
            } 
             else if(!arr[i].equals("..")){
                
                    stack.push(arr[i]);
                
            }
             
        }
        // System.out.println(stack);
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
             
                ans.insert(0,("/" + stack.pop()));

           
        }
        if(ans.length() == 0) return "/";
        else return ans.toString();
    }
} */


class Solution {
    public String simplifyPath(String path) {
        return simplified_string(path);
    }
    public static String simplified_string(String path){
        String [] arr=path.split("/");
        Stack <String> st=new Stack<>();
        for(String i : arr){
            if(i.equals("..") && !st.isEmpty()){
                st.pop();
            }else if(!i.equals("") && !i.equals(".") && !i.equals("..")){
                st.push(i);
            }
        }
        // System.out.print(st);
        StringBuilder sb = new StringBuilder();
        for(String i : st){
            sb.append("/");
            sb.append(i);
        }
        return sb.length()==0 ? "/" : sb.toString();
    }
}