class Solution {
    public String simplifyPath(String path) {
        return SimplifyPath(path);
    }

    public   String SimplifyPath(String path) {
        String[] arr = path.split("/+");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].isEmpty() || arr[i].equals(".")) {
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
}