// class Solution {
//     public String decodeCiphertext(String encodedText, int rows) {
//         if(encodedText.length() == 0) return "";
//         int n = encodedText.length();
//         int cols = n / rows;
//         char[][] grid = new char[rows][cols];
//         int idx = 0;
//         for(int i = 0;i < rows; i++) {
//             for(int j = 0; j < cols; j++) {
//                 char ch = encodedText.charAt(idx);
//                 if(ch == ' ') grid[i][j] = ' ';
//                 else grid[i][j] = ch;
//                 idx++;
//                 // System.out.print(grid[i][j] + " ");
//             }
//             // System.out.println();
//         }
//         StringBuilder sb = new StringBuilder();
//         for(int col = 0; col < cols; col++) {
//             int j = col;
//             for(int row = 0; row < rows;) {
            
//                 if(j < cols && row < rows && grid[row][j] != ' ' ) {
//                     sb.append(grid[row][j]);
//                 } else {
//                     sb.append(" ");
//                 }
//                 j++;
//                 row++;
//             }
//         }
//         int index = 0;
//         for(int i = sb.toString().length()-1; i >= 0; i--) {
//             if(sb.toString().charAt(i) != ' ') {
//                 index = i;
//                 break;
//             }
//         }
//         return sb.toString().substring(0, index+1);
//         // return sb.toString().trim();
//     }
// }






class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (encodedText.length() == 0) return "";
        
        int n = encodedText.length();
        int cols = n / rows;
        
        char[][] gr = new char[rows][cols];
        int id = 0;
        
        // fill grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                gr[i][j] = encodedText.charAt(id++);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        // diagonal traversal
        for (int c = 0; c < cols; c++) {
            int i = 0, j = c;
            
            while (i < rows && j < cols) {
                sb.append(gr[i][j]);
                i++;
                j++;
            }
        }
        
        // remove trailing spaces
        int end = sb.length() - 1;
        while (end >= 0 && sb.charAt(end) == ' ') {
            end--;
        }
        
        return sb.substring(0, end + 1);
    }
}