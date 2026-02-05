class Solution {

    public class Trans{
    public String name;
    public int time;
    public int amount;
    public String city;
    
    public Trans(String transVal){

        String[] splitted = transVal.split(",");
        this.name=splitted[0];
        this.time=Integer.parseInt(splitted[1]);
        this.amount=Integer.parseInt(splitted[2]);
        this.city=splitted[3];
    }
}

    public List<String> invalidTransactions(String[] transactions) {
        
        List<String> ans = new ArrayList<String>();
        
        Map<String, List<Trans>> allTrans = new HashMap<String, List<Trans>>();
        
        for(String t:transactions){
            
            Trans tran = new Trans(t);                             
            allTrans.putIfAbsent(tran.name, new ArrayList<Trans>());
            allTrans.get(tran.name).add(tran);
        }
        
        for(String currt:transactions){
            
             Trans tran2 = new Trans(currt);
                    
            
            if(tran2.amount>1000){
                ans.add(currt);
            } 
            else if(allTrans.containsKey(tran2.name)){
                
                for(Trans trans: allTrans.get(tran2.name)){

                    if(Math.abs(tran2.time-trans.time)<=60&&!tran2.city.equals(trans.city)){
                        ans.add(currt);
                        break;
                    }
                }
                           
            
        }
        
    }
       return ans;               
}
}