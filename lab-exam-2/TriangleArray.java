import java.util.Scanner;

public class TriangleArray {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n = ");
        int n = scanner.nextInt();
        int c = 0;
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = c++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }

}
