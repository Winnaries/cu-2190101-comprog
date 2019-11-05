import java.util.*; 
public class ArrayListExample3 {

	public static void main(String[] args) {
		/*
		 *There are three ways to initialize ArrayList
		 	ArrayList() builds an empty arraylist
			
			ArrayList(Collection c) builds an array list 
			     that is initialized with the elements of the collection c
			
			ArrayList(int capacity) builds an array list with a specified capacity
			
			Let's build an arraylist with specify capacity
		 */
		
		ArrayList<Integer> numbers = new ArrayList<Integer>(3);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		// ArrayList also provides many methods to add, remove, access and etc.
		// For example
		// ArrayList can return a string representation of all elements in the ArrayList
		// via "toString" method
		System.out.println(numbers.toString() + "\n");

		// add more student
		System.out.println("Add more student.");
		numbers.add(1,99);
		System.out.println(numbers.toString() + "\n");

		// get method
		System.out.println("Test get method.");
		System.out.println("Number at index 1 is " + numbers.get(1) + ".\n");

		// set method
		System.out.println("Test set method.");
		numbers.set(0,999);
		System.out.println(numbers.toString() + "\n");

		// remove(index) method
		System.out.println("Let's remove one number from the ArrayList.");
		numbers.remove(3);
		System.out.println(numbers.toString());
	}
}