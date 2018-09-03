/**
*importing Scanner foem java.util.
*/
import java.util.Scanner;
/**
*implementing Soultion class.
*/
public class Solution {
    /**
    *declaring a default constructor.
    */
    private void solution() {
    }
    /**
    *Do not modify this main function.
    *@param args String.
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            String s = scan.next();
            int resultant_string = binaryToDecimal(s); //Write binaryToDecimal function
            System.out.println(resultant_string);
        }
    }
    /**
    *implementing a function for binary to decimal conversion.
    *@param s String.
    *@return resultant_string int.
    */
    public static int binaryToDecimal(final String s) {
        double resultant_string = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                resultant_string = resultant_string + 
                Math.pow(2, s.length() - 1 - i);
            }
        }
        return (int) resultant_string;
    }
}
