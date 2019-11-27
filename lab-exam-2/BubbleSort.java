import java.util.Arrays;

public class BubbleSort {

    public static void main (String[] args) {
        int[] data = { 2, 4, 3, 5, 6, 4, 6, 8, 3, 8, 4, 6, 5, 3, 2 };
        System.out.println(Arrays.toString(data));
        System.out.println(Arrays.toString(sort(data)));
    }

    public static int[] sort(int[] data) {
        return sort(data, 0, 0);
    }

    public static int[] sort(int[] data, int pointer, int locked) {
        if (locked == data.length) return data;
        if (data[pointer] > data[pointer + 1]) {
            int temp = data[pointer];
            data[pointer] = data[pointer + 1];
            data[pointer + 1] = temp;
        }
        if (pointer >= data.length - 2 - locked) return sort(data, 0, ++locked);
        return sort(data, pointer + 1, locked);
    }

}
