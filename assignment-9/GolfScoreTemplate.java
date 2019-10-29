package toStudent;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class GolfScoreTemplate {
	final static int HOLE_NUM = 18;

	public static void main(String[] args) {
		int lineCount = countLineInFile("golf-score.csv", 1);
		String[] golfers = getGolfersFromFile("golf-score.csv", 1);
		int[][] golfScoreList = getScoresFromFile("golf-score.csv", 1);
		int[][] scores = calculateScore(golfScoreList);
		int[] hc = calculateHandicap(golfScoreList);
		printReport(lineCount, golfers, scores, hc);
	}
		
	public static int countLineInFile(String filename, int headers) {
		// count how many lines that are data, exclude headers
		Scanner fileScanner = null;
		int lineCount = 0;
		// -- fill code --
		
		return lineCount;
	}

	public static String[] getGolfersFromFile(String filename, int headerLines) {
		// return array of String which contain all golfer names
		// exclude headers
		Scanner fileScanner = null;
		int totalGolfer = countLineInFile(filename, headerLines);
		String[] golfers = new String[totalGolfer];
		// -- fill code --
		
		return golfers;
	}

	public static int[][] getScoresFromFile(String filename, int headerLines) {
		// return 2D array of int which:
		//   # of rows = total gofers
		//   # of columns = total holes (18)
		Scanner fileScanner = null;
		int totalGolfer = countLineInFile(filename, headerLines);
		int[][] golfScoreList = new int[totalGolfer][HOLE_NUM];
		// -- fill code --
		
		return golfScoreList;
	}

	public static int[][] calculateScore(int[][] golfScoreList){
		// calculate:
		//   sum(hole1 to hole9) -> out
		//   sum(hole10 to hole18) -> in
		//   out + in -> total
		// then append to the end of each row
		int[][] scoreWithTotal = new int[golfScoreList.length][HOLE_NUM+3];
		// -- fill code --
		
		return scoreWithTotal;
	}
	
	public static int[] calculateHandicap(int[][] scores) {
		// return handicap of all golfers using System36 calculation
		int[] hc = new int[scores.length-1]; // not include header
		// -- file code --
		return hc;
	}
	
	private static void printReport(int lineCount, String[] golfers, int[][] scores, int[] hc) {
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
}
