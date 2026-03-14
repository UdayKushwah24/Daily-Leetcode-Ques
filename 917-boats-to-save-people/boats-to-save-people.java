/* class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boat = 0;
        PriorityQueue<Integer> large = new PriorityQueue<>();
        PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < people.length; i++) {
            if (people[i ] == limit) {
                boat++;
            } else {
                large.add(people[i]);
                small.add(people[i]);
            }
        }

        while (!large.isEmpty() && !small.isEmpty()) {
            if (large.peek() + small.peek() == limit) {
                boat++;
                large.poll();
                small.poll();
            } else {
                break;
            }
        }
       
        boat += large.size();
        return boat;
    }
} */


/* 
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boat = 0;
        Arrays.sort(people);
        int i = 0; 
        int j = people.length-1;
        while(i <= j) {
            if(people[i] + people[j] <= limit) {
                i++;
                j--;
            } else {
                j--;
            }
            boat++;
        }
        return boat;
    }
} */


class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boat = 0;
        Arrays.sort(people);
        int i = 0; 
        int j = people.length-1;
        while(i <= j) {
            if(people[i] + people[j] <= limit) {
                i++;
            } 
            j--;
            boat++;
        }
        return boat;
    }
}