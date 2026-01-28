class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> student = new LinkedList<>();
        //Stack<Integer> sandwich = new Stack<Integer>();
        int count0 = 0;
        int count1 = 0;
        for (int a : students) {
            if (a == 0) {
                count0 += 1;
            } else {
                count1 += 1;
            }
            student.add(a);
        }
        int j = 0;
        while (j < sandwiches.length) {
            int sandwich = sandwiches[j];
            if ((sandwich == 1 && count1 == 0) || (sandwich == 0 && count0 == 0))
                break;
            if (sandwich == student.peek()) {
                j++;
                if (sandwich == 0) {
                    count0--;
                }
                if (sandwich == 1)
                    count1--;
                student.poll();
            } else {
                int rv = student.poll();
                student.add(rv);
            }
            
        }
        return student.size();
    }
}