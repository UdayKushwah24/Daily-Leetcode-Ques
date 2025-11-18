class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> lst = new ArrayList<>();
        if(digits.length() == 0) {
            return lst;
        }
        LetterCombination(digits, "",lst);
        return lst;
    }    
    static String[] key = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public static void LetterCombination(String ques,String ans, List<String> lst) {
        if(ques.length() ==0){
            lst.add(ans);
            return;
        }

        char ch = ques.charAt(0);
        String getString = key[ch-'0'];
        for (int i = 0; i < getString.length(); i++) {
            LetterCombination(ques.substring(1), ans+getString.charAt(i),lst);
        }
    }
}