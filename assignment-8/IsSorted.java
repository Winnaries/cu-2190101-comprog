public class IsSorted {

	public static boolean isSorted(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 2, 3, 4, 5 };
		int[] b = { 2, 6, 1, 32, 4, 5 };
		int[] c = { 1, 2, 0, 3, 4, 5 };

		System.out.println(isSorted(a) + ", expected to be true");
		System.out.println(isSorted(b) + ", expected to be false");
		System.out.println(isSorted(c) + ", expected to be false");
	}

}
