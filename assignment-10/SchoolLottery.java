import java.util.*;
import java.io.*;

public class SchoolLottery{
	private ArrayList<String> entries;	// holds Student references
	public SchoolLottery(){ entries = new ArrayList<>(); }

	public void addStudents() throws FileNotFoundException {
		File file = new File("./studentList.txt");
		Scanner input = new Scanner(file);
		int studentNum = 0;
		System.out.println("Please Enter to end input");
		while (input.hasNext()) {	// signals end of data
			System.out.print("\nName" + ++studentNum + ": ");
			String name = input.nextLine();
			if (!entries.contains(name)) {
				entries.add(name);
				System.out.println(name + " entered in the lottery.");
			} else {
				studentNum--;
				System.out.println("The specified name is duplicate inside the list.");
			}
		}
		pickWinner();
	}

	public void pickWinner() {
		int numEntries = entries.size();	// size of ArrayList
		if (numEntries == 0)
			System.out.println("*** No participants ***");
		else {
			Random random = new Random();
			String winner = entries.get(random.nextInt(numEntries));
			System.out.print("\n*** The winner is " + winner + " ***");
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		SchoolLottery lottery = new SchoolLottery();
		lottery.addStudents();
	}
}