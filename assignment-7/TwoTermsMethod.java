import java.util.Scanner;

public class TwoTermsMethod {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter 5 inputs (a, x, b, r, n): ");
		int a = scanner.nextInt();
		int x = scanner.nextInt();
		int b = scanner.nextInt();
		int r = scanner.nextInt();
		int n = scanner.nextInt();
		double y = calculateY(a, x, b, r, n);
		printInputsAndOutput(a, x, b, r, n, y);
	}
	
	public static double axMinusLnB(int a, int x, int b) {
		return b > 0 ? a * x - Math.log(b) : a * x;
	}
	
	public static double sumNegSquaredI(int n) {
		double result = 0;
		for (int i = 1; i <= n; i++) {
			result += Math.pow(-1, n + 1) * i * i;
		}
		return result;
	}

	public static double calculateY(int a, int x, int b, int r, int n) {
		return axMinusLnB(a, x, b) * r + sumNegSquaredI(n) * r * r;
	}
	
	public static void printInputsAndOutput(int a, int x, int b, int r, int n, double y) {
		System.out.printf("Inputs (a, x, b, r, n) = %d, %d, %d, %d, %d %n", a, x, b, r, n);
		System.out.printf("Output (y) = %.2f %n", y);
	}

}