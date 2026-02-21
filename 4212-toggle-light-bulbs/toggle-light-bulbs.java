class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        List<Integer> ll=new ArrayList<>();
     Map<Integer,Integer> mp=new TreeMap<>();
        for(int i:bulbs){
            if(mp.containsKey(i)){
                mp.put(i,mp.getOrDefault(i,0)+1);
            }
            else{
                mp.put(i,1);
            }
        }
        for(int i:mp.keySet()){
            if(mp.get(i)%2==1){
                ll.add(i);
            }
        }
        return ll;
    }
}