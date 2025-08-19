package DailyLeetcodeQuestion.ApplyDiscount_1357;

public class Cashier {
    int count = 0;
    int n;
    int discount;
    int[] products;
    int[] prices;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        this.products = products;
        this.prices = prices;

    }

    public   double getBill(int[] product, int[] amount) {
        count++;
        double ans = 0;
        int bill = 0;
        for (int i = 0; i < amount.length; i++) {
            int productId = product[i];
            int idx = -1;
            for (int j = 0; j < products.length; j++) {
                if (productId == products[j]) {
                    idx = j;
                    break;
                }
            }
            int price;
            if (idx != -1) {
                
                 price = prices[idx];
                 bill += price * amount[i];
            }

        }
        if (count == n) {
            count = 0;
            return bill * (100 - discount) / 100.0;
        }
        // System.out.println(bill);
        return bill;
    }

    
}

/* 

 package DailyLeetcodeQuestion.ApplyDiscount_1357;

 import java.util.*;
public class Cashier {
    int count = 0;
    int n;
    int discount;
    int[] products;
    int[] prices;
    Map<Integer, Integer> priceMap;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        this.products = products;
        this.prices = prices;
        this.priceMap = new HashMap<>();
        for (int i = 0; i < prices.length; i++) {
            priceMap.put(products[i], prices[i]);
        }

    }

    public double getBill(int[] product, int[] amount) {
        count++;
        
        double bill = 0;
        for (int i = 0; i < amount.length; i++) {
            int productId = product[i];
             
            int price = priceMap.get(productId);
            bill += price * amount[i];

        }
        if (count == n) {
            count = 0;
            return bill * (100 - discount) / 100.0;
        }
        // System.out.println(bill);
        return bill;
    }

}
 */