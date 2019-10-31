import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class GolfScore {
	final static int HOLE_NUM = 18;

	public static void main(String[] args) throws FileNotFoundException {
		int lineCount = countLineInFile("golf-score.csv", 1);
		String[] golfers = getGolfersFromFile("golf-score.csv", 1);
		int[][] golfScoreList = getScoresFromFile("golf-score.csv", 1);
		int[][] scores = calculateScore(golfScoreList);
		int[] hc = calculateHandicap(golfScoreList);
		System.out.println("");
		printNetScore(lineCount, golfers, scores, hc);
		System.out.println("");
	}
		
	public static int countLineInFile(String filename, int headers) throws FileNotFoundException {
		// count how many lines that are data, exclude headers
		File file = new File(filename);
		Scanner fileScanner = new Scanner(file);
		int lineCount = 0;
		while (fileScanner.hasNext()) {
			fileScanner.nextLine();
			lineCount++;
		}
		
		return lineCount - headers;
	}

	public static String[] getGolfersFromFile(String filename, int headerLines) throws FileNotFoundException {
		// return array of String which contain all golfer names
		// exclude headers
		File file = new File(filename);
		Scanner fileScanner = new Scanner(file).useDelimiter("[,\r\n]");
		int totalGolfer = countLineInFile(filename, headerLines);
		String[] golfers = new String[totalGolfer];
		for (int i = 0; i < headerLines; i++) {
			fileScanner.nextLine();
		}
		for (int j = 0; j < totalGolfer; j++) {
			golfers[j] = fileScanner.next();
			if (fileScanner.hasNextLine()) fileScanner.nextLine();
		}
		
		return golfers;
	}

	public static int[][] getScoresFromFile(String filename, int headerLines) throws FileNotFoundException {
		// return 2D array of int which:
		//   # of rows = total gofers
		//   # of columns = total holes (18)
		File file = new File(filename);
		Scanner fileScanner = new Scanner(file).useDelimiter("[,\r\n]");
		int totalGolfer = countLineInFile(filename, headerLines);
		int[][] golfScoreList = new int[totalGolfer][HOLE_NUM];
		for (int i = 0; i < headerLines; i++) {
			fileScanner.nextLine();
		}
		for (int m = 0; m < totalGolfer; m++) {
			fileScanner.next();
			for (int n = 0; n < HOLE_NUM; n++) {
				golfScoreList[m][n] = fileScanner.nextInt();
			}
			if (fileScanner.hasNextLine()) fileScanner.nextLine();
		}

		return golfScoreList;
	}

	public static int[][] calculateScore(int[][] golfScoreList){
		// calculate:
		//   sum(hole1 to hole9) -> out
		//   sum(hole10 to hole18) -> in
		//   out + in -> total
		// then append to the end of each row
		int[][] scoreWithTotal = new int[golfScoreList.length][HOLE_NUM + 3];
		for (int m = 0; m < golfScoreList.length; m++) {
			for (int n = 0; n < HOLE_NUM; n++) {
				scoreWithTotal[m][n] = golfScoreList[m][n];
				if (n < HOLE_NUM / 2) scoreWithTotal[m][HOLE_NUM] += golfScoreList[m][n];
				else scoreWithTotal[m][HOLE_NUM + 1] += golfScoreList[m][n];
			}
			scoreWithTotal[m][HOLE_NUM + 2] = scoreWithTotal[m][HOLE_NUM + 1] + scoreWithTotal[m][HOLE_NUM];
		}
		
		return scoreWithTotal;
	}
	
	public static int[] calculateHandicap(int[][] scores) {
		// return handicap of all golfers using System36 calculation
		int[] hc = new int[scores.length - 1]; // exclude header
		for (int m = 0; m < scores.length - 1; m++) {
			for (int n = 0; n < HOLE_NUM; n++) {
				if (scores[m + 1][n] - scores[0][n] >= 2) hc[m] += 2;
				else if (scores[m + 1][n] - scores[0][n] == 1) hc[m] += 1;
			}
		}

		return hc;
	}
	
	public static void printReport(int lineCount, String[] golfers, int[][] scores, int[] hc) {
		printOneRow(golfers[0], scores[0], "HC");
		System.out.println("--------------------------------------------------------");
		for (int i = 1; i < lineCount; i++) {
			printOneRow(golfers[i], scores[i], ""+hc[i-1]);
		}
	}

	public static void printOneRow(String player, int[] score, String hc){
		String text = "       " + player;
		System.out.print(text.substring(text.length()-8) + ":");
		for(int i=0; i<score.length; ++i){
			System.out.print(score[i] + " ");
		}
		System.out.println(hc);
	}

	public static void printNetScore(int lineCount, String[] golfers, int[][] scores, int[] hc) {
		int length = golfers.length - 1; // exclude header
		int[] net = new int[length];
		int[] buffer = new int[length];
		int[] order = new int[length];
		int temp = 0;

		for (int j = 0; j < length; j++) order[j] = j;
		for (int i = 0; i < length; i++) net[i] = scores[i + 1][HOLE_NUM + 2] - hc[i];
		for (int k = 0; k < length; k++) buffer[k] = net[k];

		for (int m = 0; m < length; m++) {
			for (int n = 1; n < length - m; n++) {
				if (buffer[n - 1] > buffer[n]) {
					temp = order[n - 1];
					order[n - 1] = order[n];
					order[n] = temp;
					temp = buffer[n - 1];
					buffer[n - 1] = buffer[n];
					buffer[n] = temp;
				}
			}
		}
		printReportEx(lineCount, golfers, scores, hc, net, order);
	}

	public static void printReportEx(int lineCount, String[] golfers, int[][] scores, int[] hc, int[] net, int[] order) {
		printOneRowEx(golfers[0], scores[0], "HC", "NET");
		System.out.println("------------------------------------------------------------");
		for (int i = 0; i < order.length; i++) {
			printOneRowEx(golfers[order[i] + 1], scores[order[i] + 1], "" + hc[order[i]], "" + net[order[i]]);
		}
	}

	public static void printOneRowEx(String player, int[] score, String hc, String net){
		String text = "       " + player;
		System.out.print(text.substring(text.length() - 8) + ":");
		for(int i=0; i < score.length; ++i){
			System.out.print(score[i] + " ");
		}
		System.out.printf("%-2s %-3s %n", hc, net);
	}
}
