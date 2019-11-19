public class ReverseArray {

	public static int[] reverse(int[] a) {
		int length = a.length;
		int[] b = new int[length];
		for (int i = 0; i < length; i++) b[i] = a[length - i - 1];
		return b;
	}

	public static void printArray(int[] a) {
		System.out.print(a[0]);
		for (int i = 1; i < a.length; i++) System.out.printf(", %d", a[i]);
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = { 2, 6, 1, 32, 4, 5 };

		a = reverse(a);
		b = reverse(b);

		printArray(a);
		printArray(b);

	}

}
