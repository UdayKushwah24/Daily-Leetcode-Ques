package DailyLeetcodeQuestion;

public class q4_ValidateIPAddress {

    public static void main(String[] args) {
        // String queryIP =  "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        String queryIP =  "12..33.4";
        // String queryIP = "172.0.254.4";
        // String queryIP = "03.0.0.0";
        // System.out.println(valideIPv4(queryIP));
        // String ip6 = "2001:0db8:85a3:0000:0000:8a2e:0370:7334";
        // System.out.println(valideIPv6(ip6));
        String ip4 = valideIPv4(queryIP);
        String ip6 = valideIPv6(queryIP);
        if (ip4.equals("Neither") && ip6.equals("Neither")) {
            System.out.println(ip4);
        } else if (ip4.equals("Neither") && ip6.equals("IPv6")) {
            System.out.println(ip6);
        } else {
            System.out.println(ip4);
        }

    }

    private static String valideIPv4(String queryIP) {
        int count = 0;
        for (int i = 0; i < queryIP.length(); i++) {
            if (queryIP.charAt(i) == '.') {
                count++;
            }
            if (count > 3) {
                return "Neither";
            }
        }
        String[] arr = queryIP.split("\\.");
        // System.out.println(count);
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.println(arr[i]);
        // }
        if (arr.length == 4) {

            for (String s : arr) {
                // System.out.print(s+" ");
                if (s.length() > 4) {
                    return "Neither";
                }
                if (s.length() == 4) {
                    return "Neither";
                }
                if (s.length() == 0) {
                    return "Neither";
                }

                
                if (Integer.valueOf(s) > 255) {
                    return "Neither";

                }
                if (s.length() >= 2 && s.charAt(0) == '0' && s.charAt(1) == '0') {
                    return "Neither";
                    
                }
                if (s.length() >= 2 && s.charAt(0) == '0' && s.charAt(1) != '0') {
                    return "Neither";
                    
                }
                 
                for (int i = 0; i < s.length(); i++) {
                     
                    if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                        return "Neither";
                    }
                }

            }
            return "IPv4";
        } else {
            return "Neither";
        }
    }
  
    private static String valideIPv6(String queryIP) {

        String[] arr = queryIP.split(":");
        int count = 0;
        for (int i = 0; i < queryIP.length(); i++) {
            if (queryIP.charAt(i) == ':') {
                count++;
            }
            if (count > 7) {
                return "Neither";
            }
        }
        System.out.println();
        if (arr.length == 8) {

            for (String s : arr) {
                if (s.length() > 4) {
                    return "Neither";
                }
                if (s.length() == 0) {
                    return "Neither";
                }

                for (int i = 0; i < s.length(); i++) {
                    if (!((s.charAt(i) >= '0' && s.charAt(i) <= '9') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'f') || (s
                            .charAt(i) >= 'A' && s.charAt(i) <= 'F'))) {
                        return "Neither";
                    }
                }

            }
            return "IPv6";
        } else {
            return "Neither";
        }
    }
 

}
