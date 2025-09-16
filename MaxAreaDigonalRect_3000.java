package DailyLeetcodeQuestion;

public class MaxAreaDigonalRect_3000 {
    public static int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDiagonal = 0;
        int maxArea = 0;
        for (int i = 0; i < dimensions.length; i++) {
            int l = dimensions[i][0];
            int w = dimensions[i][1];
            double diagonal = (Math.sqrt(l * l + w * w));
            if (diagonal > maxDiagonal) {
                maxArea = l * w;
                maxDiagonal = diagonal;
            } else if (diagonal == maxDiagonal) {
                maxDiagonal = diagonal;
                maxArea = Math.max(maxArea, l * w);
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        
    }
}

