import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MaxArrayValue {

    public static void main (String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("./score.csv"));
        while (file.hasNextLine()) {
            showMax(file.nextLine());
        }
    }

    public static int findMax(int[] scoreList) {
        int max = 0;
        for (int n : scoreList) {
            if (n > max) max = n;
        }
        return max;
    }

    public static void showMax(String line) {
        String[] original = line.split("[,\r\n]");
        int[] parsed = new int[original.length];
        for (int i = 0; i < parsed.length; i++) {
            parsed[i] = Integer.parseInt(original[i]);
        }
        System.out.printf("The max value of array {%s} is %d %n", line, findMax(parsed));
    }

}
