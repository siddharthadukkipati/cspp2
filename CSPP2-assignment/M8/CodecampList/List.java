import java.io.BufferedInputStream;
import java.util.Scanner;
/**
 * in order to store elements.
 */
public final class List {
    //Implement all the methods mentioned to build a ListADT
    /**
     * The goal for the list is to store items.
     * How are we going to store the items in the list?
     * An array would be good. Right?
     * So, assume we are only going to have ints in the list
     * We need to create an array of ints to store the items
     * added to the list.
     *
     * Create a variable of the type int[]
     * Use the private access specifier
     * Why private access specifier and why not public?
     * Well, we don't want the array to be manipulated by
     * methods that are outside the List class.
     * If you allow methods outside the List class to manipulate
     * the array then there is a possibility of having a corrupted
     * list i.e., a list with incorrect items.
     * This is not desirable and so having private access specifer
     * will protect the array such corruption.
     * This is a hard concept to understand. Discuss with your mentor.
     *
    */
    private static int[] arrayList;
    // declare a private int[]
    // don't create the array yet using new
    // that's the job of the List constructor
    /**
     * What are the other class variables needed for creating a list?
     * How about keeping track of the size of the list?
     * If you add 2 items to the list then the size should be 2.
     * Let's think about the size of the list by comparing it to the
     * length of the array. Do they mean the same?
     * No, Array length signifies the maximum number of items
     * you can store in the list. Whereas, the size of the list
     * denotes the number of items in the list. Makes sense?
     * Here is an example:
     * array = [1,2,3,0,0,0,0,0,0,0]
     * The length of the array is 10 and size is 3.
     * This means you can store 10 items in the list and
     * currently it has 3 items.
     * So, to keep track of the size we need a variable called size
     * Again, we use private as we don't want that size variable
     * to be accessed by the methods that are outside of the List class.
     */
    // declare a private int size
    // again, don't initialize it here
    // variable initialization should be done in the constructor.
    /**
     * The purpose of the constructor is to initialize the
     * class variables with some default values.
     */
    private static int size;
    /**
     * Constructs the object.
     */
    public List() {

        // what are the two variables to be initialized here?
        // think about the private variables described above.
        // What should be the default values?
        // In the case of the list, it should be empty but
        // it should be initialized with an array size like 10

        // Think about the initial value for size.
        // How many items do we have in the list when you create it?
        // An empty list has how many items?
        // That is the initial value to use for size.
        size = 0;
        final int n = 10;
        arrayList = new int[n];
    }
    /**
    *Add all method.
    *@param items integer data type.
    */
    public void addAll(final int[] items) {
        int temp = 0;
        for (int i = size; i < (size + items.length); i++) {
            arrayList[i] = items[temp];
            temp++;
        }
        //System.out.println(Arrays.toString(arrayList));
    }
    /**
    *Add method.
    *@param index integer data type.
    *@param item integer data type.
    */
    public void add(final int index, final int item) {
        for (int i = size; i > index; i--) {
            arrayList[i] = arrayList[i - 1];
        }
        arrayList[index] = item;
        size++;
    }
    /**
    *This method uses to count the occurance of the item.
    *@param item integer data type.
    *@return boolean type.
    */
    public int count(final int item) {
        int count1 = 0;
        for (int i = 0; i < size; i++) {
            if (arrayList[i] == item) {
                count1++;
            }
        }
        if (count1 > 0) {
            return count1;
        } else {
            return -1;
        }
    }
    /**
     * The add method does what the name suggests.
     * Add an int item to the list.
     * The assumption is to store the item at the end of the list
     * What is the end of the list?
     * Is it the same as the end of the array?
     * Think about how you can use the size variable to add item
     * to the list.
     * The method returns void (nothing)
     */
    /**
     *add items into array.
     * @param item int
     */
    public void add(final int item) {
        //Inserts the specified element at the end of the list.
        arrayList[size] = item;
        size++;
    }
    /**
     * The size method returns the value of the size.
     * The purpose of the method is to announce the size of the list
     * to the objects outside the list
     *
     * The method returns an int. Empty list should return 0.
     */
    /**
     * return size.
     * @return size
     */
    public int size() {
        // replace the code below to implement the size method
        return size;
    }

    /**
     * The remove method does what the name suggests.
     * Removes an int item, specified by the index argument, from the list
     * It also does an additional step.
     * Think about what happens when
     * an item is removed from the middle of the list
     * It creates a hole in the list, right?
     * This would mean, all the items that are
     * to the right side of the removed item should be
     * moved to the left by one position.
     * Here is an example:
     * array = [1,2,3,0,0,0,0,0,0,0]
     * remove(1) would remove the item 2 which is at index position 1.
     * But how do you remove the item from an array?
     * Well, the way to remove it is to move all
     * the items, that are to the right of the removed item, to the left
     * So, the new array looks like this.
     * array = [1,3,0,0,0,0,0,0,0,0]
     * The method returns void (nothing)
     */
    /**
     * remove the value of guven index.
     * @param index int
     */
    public void remove(final int index) {
        // write the logic for remove here.
        // Think about what to do to the size variable.
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
            arrayList[i] = arrayList[i + 1];
        }
        arrayList[size] = 0;
        size--;
    } else {
        System.out.println("Invalid Position Exception");
        }
    }
    /**
     * Get method has to return the items that is
     * at the index position passed as an argument to the method.
     * If the item doesn't exist then return a -1 to indicate that
     * there is no element at that index.
     * How can an element not be there at a given position?
     * Well, if the position is greater than the number of items
     * in the list then that would mean the item doesn't exist.
     * How do we check if the position is greater than the
     * number of items in the list? Would size variable be useful?
     */
    /**
     * get the items.
     * @param index int
     */
    public void get(final int index) {
        if (index > 0 && index < size) {
            System.out.println(arrayList[index]);
        }
    }

    /**
     * What happens when you print an object using println?
     * Java provides a method named toString that is internally
     * invoked when an object variable is used in println.
     * For example:
     * List l = new List();
     * System.out.println(l);
     * This statement is a shortcut for
     * System.out.println(l.toString());
     * So, implement the toString method to display the items
     * in the list in the square brackets notation.
     * i.e., if the list has numbers 1, 2, 3
     * return the string [1,2,3]
     * Caution: The array may be having other elements
     * Example: [1,2,3,0,0,0,0,0,0,0]
     * toString should only return the items in the list and
     * not all the elements of the array.
     *
     */
    /**
     * Returns a string representation of the object.
     *
     * @return String
     */
    public String toString() {
        // Replace the code below.
        String temp = "[";
        for (int i = 0; i < size; i++) {
            temp += arrayList[i] + ",";
        }
        return (temp.substring(0, temp.length() - 1) + "]");
    }
    /**
     * Contains return true if the list has
     * the item passed as an argument to the method
     * So, iterate through the list and return true if
     * the item exists and otherwise false
     */
    /**
     * checking for the value.
     * @param item int
     * @return boolean
     */
    public boolean contains(final int item) {
        // Replace the code below
        for (int i = 0; i < size; i++) {
            if (arrayList[i] == item) {
                 return true;
            }
        }
        return false;
    }

    /**
     * Returns the index of the first occurrence
     * of the specified element in this list,
     * or -1 if this list does not contain the element.
     */
    /**
     * Searches for the first match.
     *
     * @param item int
     *
     * @return index
     */
    public int indexOf(final int item) {
        // Replace the code below
        for (int i = 0; i < size; i++) {
            if (arrayList[i] == item) {
                return i;
            }
        }
        return -1;
    }
    /**
     * main method.
     *
     * @param args  String
     */
    public static void main(final String[] args) {
        // create an object of the list to invoke methods on it
        final int a = 3;
        List l = new List();
        int[] items = new int[]{1, 2, a};

        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "add":
                if (tokens.length > 2) {
                    l.add(Integer.parseInt(tokens[1]),
                        Integer.parseInt(tokens[2]));
                } else {
                    l.add(Integer.parseInt(tokens[1]));
                }
                break;
                case "size":
                // invoke size method and print the list size
                // BTW, list size is not the array size
                // it is the number of items in the list
                System.out.println(l.size());
                break;
                case "print":
                // print the list (implement toString for this to work)
                // expected format is [item-1,item-2,...,item-n]
                // review the output testcase file
                System.out.println(l);
                break;
                case "remove":
                l.remove(Integer.parseInt(tokens[1]));
                break;
                case "indexOf":
                System.out.println(l.indexOf(Integer.parseInt(tokens[1])));
                break;
                case "get":
                l.get(Integer.parseInt(tokens[1]));
                break;
                case "contains":
                System.out.println(l.contains(Integer.parseInt(tokens[1])));
                break;
                case "addAll":
                l.addAll(items);
                break;
                case "count":
                System.out.println(l.count(Integer.parseInt(tokens[1])));
                break;

                default:
            }
        }
    }
}
