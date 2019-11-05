import java.util.*; 

public class ArrayListExample {

	public static void main(String[] args) {
		ArrayList<String> students = new ArrayList<String>(3);
		students.add("Somchai");
		students.add("Pat");
		students.add("Sam");
		students.add("Somjai");
		System.out.println(students.toString());
	}
}