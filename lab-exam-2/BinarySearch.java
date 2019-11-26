import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        int[] list = { 2, 4, 5, 10, 15, 16, 17, 20, 22, 50 };
        Scanner scanner = new Scanner(System.in);
        System.out.print("n = ");
        int n = scanner.nextInt();
        int index = indexOf(list, n, 0, 9);
        if (index == -1) System.out.printf("%d is not found! %n", n);
        else System.out.printf("%d is found at index %d. %n", n, index);
    }

    public static int indexOf(int[] list, int value, int pos_left, int pos_right) {
        int pos_center = ((pos_right - pos_left) / 2) + pos_left;
        if (pos_left == pos_center) return -1;
        if (value > list[pos_center]) return indexOf(list, value, pos_center, pos_right);
        if (value < list[pos_center]) return indexOf(list, value, pos_left, pos_center);
        return pos_center;
    }

}
