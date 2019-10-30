import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class GolfScoreTemplate {
	final static int HOLE_NUM = 18;

	public static void main(String[] args) throws FileNotFoundException {
		int lineCount = countLineInFile("golf-score.csv", 1);
		String[] golfers = getGolfersFromFile("golf-score.csv", 1);
		int[][] golfScoreList = getScoresFromFile("golf-score.csv", 1);
		int[][] scores = calculateScore(golfScoreList);
		int[] hc = calculateHandicap(golfScoreList);
		printReport(lineCount, golfers, scores, hc);
	}

	public static int countLineInFile(String filename, int headers) throws FileNotFoundException {
		File file = new File(filename);
		Scanner fileScanner = new Scanner(file);
		int lineCount = 0;

		while (fileScanner.hasNextLine()) {
			fileScanner.nextLine();
			lineCount++;
		}
		return lineCount - headers;
	}

	public static String[] getGolfersFromFile(String filename, int headerLines) throws FileNotFoundException {
		File file = new File(filename);
		Scanner fileScanner = new Scanner(file).useDelimiter("[,\r\n]");
		int totalGolfer = countLineInFile(filename, headerLines);
		String[] golfers = new String[totalGolfer];
		for (int i = 0; i < headerLines; i++) {
			fileScanner.nextLine();
		}
		for (int j = 0; j < totalGolfer; j++) {
			golfers[j] = fileScanner.next();
			fileScanner.nextLine();
		}
		return golfers;
	}

	public static int[][] getScoresFromFile(String filename, int headerLines) throws FileNotFoundException {
		File file = new File(filename);
		Scanner fileScanner = new Scanner(file).useDelimiter("[,\r\n]");
		int totalGolfer = countLineInFile(filename, headerLines);
		int[][] golfScoreList = new int[totalGolfer][HOLE_NUM];
		for (int a = 0; a < totalGolfer; a++) {
			fileScanner.nextLine();
			fileScanner.next();
			for (int b = 0; b < HOLE_NUM; b++) {
				golfScoreList[a][b] = fileScanner.nextInt();
			}
		}

		return golfScoreList;
	}

	public static int[][] calculateScore(int[][] golfScoreList){
		int[][] scoreWithTotal = new int[golfScoreList.length][HOLE_NUM + 3];
		for (int a = 0; a < golfScoreList.length; a++) {
			scoreWithTotal[a][HOLE_NUM] = 0;
			scoreWithTotal[a][HOLE_NUM + 1] = 0;
			for (int b = 0; b < HOLE_NUM; b++) {
				scoreWithTotal[a][b] = golfScoreList[a][b];
				if (b < HOLE_NUM / 2) scoreWithTotal[a][HOLE_NUM] += golfScoreList[a][b];
				else scoreWithTotal[a][HOLE_NUM + 1] += golfScoreList[a][b];
			}
			scoreWithTotal[a][HOLE_NUM + 2] = scoreWithTotal[a][HOLE_NUM] + scoreWithTotal[a][HOLE_NUM + 1];
		}
		return scoreWithTotal;
	}

	public static int[] calculateHandicap(int[][] scores) {
		int[] hc = new int[scores.length - 1];
		for (int i = 0; i < hc.length; i++) {
			for (int j = 0; j < HOLE_NUM; j++) {
				if (scores[i + 1][j] - scores[0][j] >= 2) hc[i] += 2;
				else if (scores[i + 1][j] - scores[0][j] == 1) hc[i]++;
			}
		}
		return hc;
	}

	private static void printReport(int lineCount, String[] golfers, int[][] scores, int[] hc) {
		printOneRow(golfers[0], scores[0], "HC");
		System.out.println("--------------------------------------------------------");
		for (int i = 1; i < lineCount; i++) {
			printOneRow(golfers[i], scores[i], ""+hc[i-1]);
		}
	}

	public static void printOneRow(String player, int[] score, String hc) {
		String text = "       " + player;
		System.out.print(text.substring(text.length()-8) + ":");
		for(int i=0; i<score.length; ++i){
			System.out.print(score[i] + " ");
		}
		System.out.println(hc);
	}
}
