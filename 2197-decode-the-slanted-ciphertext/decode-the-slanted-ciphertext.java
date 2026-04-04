class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (encodedText.length() == 0)
            return "";
        int n = encodedText.length();
        int cols = n / rows;
        char[][] grid = new char[rows][cols];
        int idx = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char ch = encodedText.charAt(idx);
                grid[i][j] = ch;
                idx++;

            }

        }
        StringBuilder sb = new StringBuilder();
        for (int col = 0; col < cols; col++) {
            int j = col;
            int i = 0;
            while (j < cols && i < rows) {
                sb.append(grid[i][j]);
                j++;
                i++;
            }
        }
    
        int index = 0;
        int end = sb.length();
        for(int i = end - 1;i>=0;i--){
            if (sb.charAt(i) != ' ') {
                index = i;
                break;
            }
        }
        return sb.substring(0,index+1);
    // return sb.toString().trim();
    }
}

// class Solution {
//     public String decodeCiphertext(String encodedText, int rows) {
//         if (encodedText.length() == 0) return "";

//         int n = encodedText.length();
//         int cols = n / rows;

//         char[][] gr = new char[rows][cols];
//         int id = 0;

//         // fill grid
//         for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < cols; j++) {
//                 gr[i][j] = encodedText.charAt(id++);
//             }
//         }

//         StringBuilder sb = new StringBuilder();

//         // diagonal traversal
//         for (int c = 0; c < cols; c++) {
//             int i = 0, j = c;

//             while (i < rows && j < cols) {
//                 sb.append(gr[i][j]);
//                 i++;
//                 j++;
//             }
//         }

//         // remove trailing spaces
//         int end = sb.length() - 1;
//         while (end >= 0 && sb.charAt(end) == ' ') {
//             end--;
//         }

//         return sb.substring(0, end + 1);
//     }
// }