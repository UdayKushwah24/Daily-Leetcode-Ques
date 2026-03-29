class EventManager {

    class event {
        int id;
        int priority;
        public event(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }

    PriorityQueue<event> pq = new PriorityQueue<>(new Comparator<event>(){
        @Override
        public int compare(event e1, event e2) {
            if(e1.priority == e2.priority) {
                return e1.id - e2.id;
            } else {
                return e2.priority - e1.priority;
            }
        }
    });
    HashMap<Integer, Integer> map = new HashMap<>();

    public EventManager(int[][] events) {
        for(int[] e : events) {
            pq.add(new event(e[0], e[1]));
            map.put(e[0], e[1]);
        }
    }
    
    public void updatePriority(int eventId, int newPriority) {
        // List<event> ll = new ArrayList<>();
        // while(!pq.isEmpty()) {
        //     event e = pq.poll();
        //     if(e.id == eventId) {
        //         ll.add(new event(eventId, newPriority));
        //     } else{
        //         ll.add(e);
        //     }
        // }
        // for(event e : ll) {
        //     pq.add(e);
        // }
        // ll.clear();
         pq.add(new event(eventId, newPriority));
         map.put(eventId, newPriority);
    }
    
    public int pollHighest() {
        // if(pq.isEmpty()) {
        //     return -1;
        // }
        // return pq.poll().id;
        while(!pq.isEmpty()) {
            event top = pq.poll();
            if (map.containsKey(top.id) && map.get(top.id) == top.priority) {
                map.remove(top.id);
                return top.id;
            }
        }
        return -1;
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */