import java.util.*;

public class SchoolLottery{
	private ArrayList<String> entries;	// holds Student references
	public SchoolLottery(){
		entries = new ArrayList<>();
	}

	public void addStudents(){
		// prompts for student names
		// adds students to entries list
		// allow duplicate entries
		Scanner input = new Scanner(System.in);
		int studentNum = 0;
		System.out.println("Please Enter to end input");
		System.out.print("Name" + ++studentNum + ": ");
		String name = input.nextLine();
		while (!name.equals("")){			// signals end of data
			entries.add(name);
			System.out.println(name + " entered in the lottery.");
			System.out.print("\nName" + ++studentNum + ": ");
			name = input.nextLine();
		}
		pickWinner();
	}

	public void pickWinner(){
		// chooses a random entry and displays winners name
		int numEntries = entries.size();	// size of ArrayList
		if(numEntries == 0)
			System.out.println("*** No participants ***");
		else{
			Random random = new Random();
			String winner = entries.get(random.nextInt(numEntries));
			System.out.print("\n*** The winner is " + winner + " ***");
		}
	}

	public static void main(String[] args){
		SchoolLottery lottery = new SchoolLottery();
		lottery.addStudents();
	}
}