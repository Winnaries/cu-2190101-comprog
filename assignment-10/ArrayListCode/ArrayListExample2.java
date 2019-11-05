import java.util.*; 
public class ArrayListExample2 {

	public static void main(String[] args) {
		ArrayList<String> students = new ArrayList<String>(3);
		students.add("Somchai");
		students.add("Pat");
		students.add("Sam");
		
		// via "toString" method
		System.out.println(students.toString() + "\n");

		// add more student
		System.out.println("Add more student.");
		students.add(1,"Somjai");
		System.out.println(students.toString() + "\n");

		// get method
		System.out.println("Test get method.");
		System.out.println("Student at index 1 is " + students.get(1) + ".\n");

		// set method
		System.out.println("Test set method.");
		students.set(0,"Chai");
		System.out.println(students.toString() + "\n");

		// remove(object) method
		System.out.println("Let's remove one student from the ArrayList.");
		students.remove("Sam");
		System.out.println(students.toString() + "\n");

		// remove(index) method
		System.out.println("Remove more student.");
		students.remove(1);
		System.out.println(students.toString() + "\n");

		// indexOf method
		System.out.println(students.indexOf("Chai"));
		System.out.println(students.indexOf("Sam"));
	}
}