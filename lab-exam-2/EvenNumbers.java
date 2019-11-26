import java.util.ArrayList;
import java.util.Scanner;

public class EvenNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String temp = "";
        int n = scanner.nextInt();
        while (n >= 0) {
            temp = temp.concat(n + " ");
            n = scanner.nextInt();
        }
        String[] strArr = temp.split(" ");
        ArrayList<Integer> list = new ArrayList<Integer>(strArr.length);
        for (String s : strArr) list.add(Integer.parseInt(s));
        String even = "[";
        String odd = "[";
        for (int a : list) {
            if (a % 2 == 0) even = even.concat(a + ",");
            else odd = odd.concat(a + ",");
        }
        even = even.replaceAll(",$", "]");
        odd = odd.replaceAll(",$", "]");
        System.out.println(even);
        System.out.println(odd);
    }

}
