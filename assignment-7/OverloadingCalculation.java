import java.util.Scanner;

public class OverloadingCalculation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of inputs (max 3): ");
        int n = scanner.nextInt();
        int a, b, c;
        if (n == 3) {
            System.out.print("Enter input1: ");
            a = scanner.nextInt();
            System.out.print("Enter input2: ");
            b = scanner.nextInt();
            System.out.print("Enter input3: ");
            c = scanner.nextInt();
            System.out.printf("Sum is %d%n", calculate(a, b, c));
        } else if (n == 2) {
            System.out.print("Enter input1: ");
            a = scanner.nextInt();
            System.out.print("Enter input2: ");
            b = scanner.nextInt();
            System.out.printf("Sum is %d%n", calculate(a, b));
        } else if (n == 1) {
            System.out.print("Enter input1: ");
            a = scanner.nextInt();
            System.out.printf("Sum is %d%n", calculate(a));
        }
    }

    public static int calculate(int a) {
        return (int) ((1 + a) * (a / 2.0));
    }

    public static int calculate(int a, int b) {
        int sum = 0;
        for (int i = 1; i <= a; i++) {
            sum += (int) Math.pow(i, b);
        }
        return sum;
    }

    public static int calculate(int a, int b, int c) {
        return (int) Math.pow(b, c) * a;
    }

}
