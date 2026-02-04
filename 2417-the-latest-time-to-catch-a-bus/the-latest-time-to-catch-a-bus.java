class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        int passenger = -1, bus = 0, currCap = 0;
        Arrays.sort(buses);
        Arrays.sort(passengers);
        while(bus < buses.length) {
            currCap = 0;
            
            while(currCap < capacity && passenger < (passengers.length-1) && passengers[passenger+1] <= buses[bus]) {
                currCap++;
                passenger++;
            }
            
            bus++;
        } 
        
        if (currCap < capacity && (passenger < 0 || buses[buses.length-1] != passengers[passenger])) {
            return buses[buses.length-1];
        }
       
        while(passenger > 0 && (passengers[passenger] - 1) == passengers[passenger-1]) {
            passenger--;
        }

        
        return passengers[passenger]-1;
    }
}