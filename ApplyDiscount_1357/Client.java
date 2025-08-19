package DailyLeetcodeQuestion.ApplyDiscount_1357;

public class Client {
    public static void main(String[] args) {
        int n = 3;
        int discount = 50;
        int[] products = { 1, 2, 3, 4, 5, 6, 7 };
        int[] prices = { 100, 200, 300, 400, 300, 200, 100 };
        Cashier cash = new Cashier(n, discount, products, prices);

        int product1[] = { 1, 2 };
        int amount1[] = { 1, 2 };
        System.out.println(cash.getBill(product1, amount1));
              
        int product2[] = { 3, 7 };
        int amount2[] = { 10, 10 };
        System.out.println(cash.getBill(product2, amount2));;       
        
        int product3[] = { 1, 2, 3, 4, 5, 6, 7};
        int amount3[] = { 1, 1, 1, 1, 1, 1, 1};
        System.out.println(cash.getBill(product3, amount3));;       
               
        int product4[] = { 4 };
        int amount4[] = { 10 };
        System.out.println(cash.getBill(product4, amount4));;       
              
        int product5[] = { 7,3 };
        int amount5[] = { 10 ,10};
        System.out.println(cash.getBill(product5, amount5));;       
        
              
        int product6[] = { 7, 5, 3, 1, 6, 4, 2 };
        int amount6[] = { 10, 10, 10, 9, 9, 9, 7 };
        System.out.println(cash.getBill(product6, amount6));;       
             
        int product7[] = { 2,3,5 };
        int amount7[] = { 5,3,2};
        System.out.println(cash.getBill(product7, amount7));;       
        
    }
}
