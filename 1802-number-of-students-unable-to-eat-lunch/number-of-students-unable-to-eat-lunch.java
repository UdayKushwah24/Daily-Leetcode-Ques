class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> student = new LinkedList<>();
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

/*

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        int c0 = 0, c1 = 0;
        for (int s : students) {
            q.add(s);
            if (s == 0) c0++;
            else c1++;
        }

        int i = 0;
        while (i < sandwiches.length) {
            int sw = sandwiches[i];
            if (sw == 0 && c0 == 0) break;
            if (sw == 1 && c1 == 0) break;
            if (q.peek() == sw) {
                q.poll();
                i++;
                if (sw == 0) c0--;
                else c1--;
            } else {
                q.add(q.poll());
            }
        }
        return q.size();
    }
}



 */