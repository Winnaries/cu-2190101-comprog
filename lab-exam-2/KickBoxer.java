import java.util.Scanner;

public class KickBoxer {

    private final static int[] limits = { 150, 300, 450, 600, 750, 900 };
    private final static String[] categories = { "Fly", "Light", "Welter", "Middle", "Cruiser", "Heavy" };

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("w = ");
            int w = scanner.nextInt();
            if (w < 0 || w > limits[limits.length - 1]) {
                System.out.println("It is not in range of weight");
                System.exit(0);
            }
            for (int i = 0; i < limits.length; i++) {
                if (w <= limits[i]) {
                    System.out.println(categories[i] + " Weight");
                    break;
                }
            }
        }
    }

}