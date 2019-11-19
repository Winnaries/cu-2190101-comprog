import java.util.Random;
import java.util.Scanner;

public class RPS {

	public static Random r = new Random();

	public static String aiRandom() {

		int i = r.nextInt(4);
		int selection = i % 3;
		switch (selection) {
			case 0:
				return "R";
			case 1:
				return "P";
			case 2:
				return "S";
		}
		return null;

	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int rounds = 0;
		while (true) {
			System.out.println("Please type the number of rounds.");
			try {
				rounds = s.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Not an integer, please try again");

			}
		}

		String[] selectionMem = new String[rounds];
		String[] aiSelectionMem = new String[rounds];

		for (int i = 1; i <= rounds; i++) {
			System.out.println("Round" + i + ":");
			String selection = "";
			while (true) {
				System.out.println("Please type your choice of R or P or S ");

				selection = s.next();
				if (selection.equals("R") || selection.equals("P") || selection.equals("S")) {
					selectionMem[i - 1] = selection;
					break;
				}
			}

			String aiSelection = aiRandom();
			aiSelectionMem[i - 1] = aiSelection;
			if (selection.equals(aiSelection)) {
				System.out.println("Your move: " + selection + ", AI move: " + aiSelection + "-> draw");
			} else if (selection.equals("R") && aiSelection.equals("S")
					|| selection.equals("P") && aiSelection.equals("R")
					|| selection.equals("S") && aiSelection.equals("P")) {

				System.out.println("Your move: " + selection + ", AI move: " + aiSelection + "-> you win");

			} else {
				System.out.println("Your move: " + selection + ", AI move: " + aiSelection + "-> you lose");
			}

		}

		s.close();

		System.out.println("------------------------");
		System.out.println("Your moves were:");
		printArray(selectionMem);
		System.out.println("AI moves were:");
		printArray(aiSelectionMem);
	}

	public static void printArray(String[] a) {
		System.out.print(a[0]);
		for (int i = 1; i < a.length; i++) System.out.printf(", %s", a[i]);
		System.out.println();
	}

}
