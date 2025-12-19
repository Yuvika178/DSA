class Solution {
    public String multiply(String num1, String num2) {

        // Edge case: agar koi bhi number "0" ho
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int n = num1.length();
        int m = num2.length();

        // Result array (max size = n + m)
        int[] result = new int[n + m];

        // Right se left multiply karte hain
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                int mul = (num1.charAt(i) - '0') * 
                          (num2.charAt(j) - '0');

                int sum = mul + result[i + j + 1];

                result[i + j + 1] = sum % 10;   // last digit
                result[i + j] += sum / 10;      // carry
            }
        }

        // Result array ko string mein convert karna
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }

        return sb.toString();
    }
}
