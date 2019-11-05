import java.util.Arrays;

public class MyArrayUtil {
	// return the first data inside the array.
	public static int head(int[] a) throws Exception {
		if (a == null)
			throw new Exception("Array is empty! No head.");
		return a[0];
	}

	// return array similar to a, but without the first data.
	public static int[] tail(int[] a) throws Exception {
		if (a == null)
			throw new Exception("Array is empty! No tail.");
		if (a.length == 1)
			return null;
		return Arrays.copyOfRange(a, 1, a.length);
	}

	// create a new array that is like array a, but with x inserted at
	// the front.
	public static int[] addAsFirst(int x, int[] a) {
		int[] ans;
		if (a == null) {
			ans = new int[1];
			ans[0] = x;
		} else {
			ans = new int[a.length + 1];
			ans[0] = x;
			for (int i = 0; i < a.length; i++) {
				ans[i + 1] = a[i];
			}
		}
		return ans;
	}

	// print array contents out.
	public static void print(int[] a) {
		if (a == null) {
			System.out.println("Array is empty!");
			return;
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			if (i != a.length - 1) {
				System.out.print(", ");
			} else {
				System.out.println(".");
			}
		}
	}

}
