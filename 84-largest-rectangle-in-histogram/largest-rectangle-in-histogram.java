class Solution {
    public int largestRectangleArea(int[] heights) {
        return Area(heights);
    }
    
	public static int Area(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] < height[stack.peek()]) {
                int h = height[stack.pop()];
                int R = i;
                if(stack.isEmpty()) {
                    area = Math.max(area, h*R);
                } else {
                    int l = stack.peek();
                    area = Math.max(h*(R-l-1), area);
                }
            }
            stack.push(i);
        }
        // System.out.println(stack);
        int R = height.length;
        while (!stack.isEmpty()) {
            int h = height[stack.pop()];
            if(stack.isEmpty()) {
                area = Math.max(area, h*R);
            } else {
                int l = stack.peek();
                area = Math.max(h*(R-l-1), area);
            }
        }
        return area;
    }


    //  public static int Area(int[] Height) {
    //     int height[] = new int[Height.length+1];
    //     for (int i = 0; i < Height.length; i++) {
    //         height[i] = Height[i];
    //     }
    //     Stack<Integer> stack = new Stack<>();
    //     int area = 0;
    //     for (int i = 0; i < height.length; i++) {
    //         while (!stack.isEmpty() && height[i] < height[stack.peek()]) {
    //             int h = height[stack.pop()];
    //             int R = i;
    //             if(stack.isEmpty()) {
    //                 area = Math.max(area, h*R);
    //             } else {
    //                 int l = stack.peek();
    //                 area = Math.max(h*(R-l-1), area);
    //             }
    //         }
    //         stack.push(i);
    //     }
    //     // System.out.println(stack);
    //     return area;
    // }
}