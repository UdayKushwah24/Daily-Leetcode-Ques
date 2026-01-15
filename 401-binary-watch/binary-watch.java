class Solution {
 
    public List<String> readBinaryWatch(int turnedOn) {
        ArrayList<String> result = new ArrayList();
        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
                    if (minute < 10) {
                        result.add(hour + ":0" + minute);
                    } else {
                        result.add(hour + ":" + minute);
                    }
                }
            }
        }
        return result;

    }
}