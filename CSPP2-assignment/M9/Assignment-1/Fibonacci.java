import java.util.Scanner;
/**.
 * In the previous module you have created List ADT.
 * ADTs are developed as reusable libraries
 * i.e., anyone who needs the ADT can use it in their program
 * A program that uses the ADT is called a "client" of the ADT
 * The client typically instantiates an object of the ADT
 * and invokes the public methods on the ADT object.
 *
 * This assignment is to practice the idea of client to the ADT.
 * Client class is Fibonacci and the client needs to use the List ADT
 * to store fibonacci numbers in the List ADT.
 * So, Fibonacci is going to instantiate an object of List ADT
 * generate fibonacci numbers and add them to the list
 * by invoking the add method provided in the List ADT.
 *
 */
public final class Fibonacci {
    /**
    *a private constructor which helps in preventing the default parameter-less
    *constructor from being used elsewhere in your code.
    */
    private Fibonacci() {

    }
    /**creating the list object of the list.java file and calling
    *the method add here.
    */
    // private static List objL = new List();
    /**
     * fib is a static method takes a argument count
     * count(n) is the count of the fibonacci numbers to be generated.
     * The method returns a List with the count fibonacci numbers.
     *@param count integer
     *@return objL List
     * Look for the hint.txt if some of the testcases fail.
     */
    public static List fib(final int count) {
        List objL = new List(count);
        objL.add(0);
        objL.add(1);
        int indexOne = 0;
        int indexTwo = 1;
        int sum;
        for (int i = 2; i < count; i++) {
            sum = indexOne + indexTwo;
            indexOne = indexTwo;
            indexTwo = sum;
            objL.add(sum);
        }
        return objL;
        }
    /**.
    *main method
    *@param args String.
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        System.out.println(fib(count));
    }
}
