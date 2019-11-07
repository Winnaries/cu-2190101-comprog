import java.util.Arrays;

public class RecursiveExercise {
	
	// return an array that has all data of ht and n,
	// just like concatenating ht and n.
	public static int[] append(int[] ht, int[] n) throws Exception {
		if (ht == null) return n;
		if (n == null) return ht;
		int[] l = append(MyArrayUtil.tail(ht),n);
		int head = MyArrayUtil.head(ht);
		return MyArrayUtil.addAsFirst(head, l);
	}
	
	public static int[] reverse(int[] ht) throws Exception {
		if (ht == null) return null;
		if (ht.length == 1) return ht;
		int[] head = Arrays.copyOfRange(ht, 0, ht.length - 1);
		return MyArrayUtil.addAsFirst(ht[ht.length - 1], reverse(head));
	}
	
	public static boolean isIn(int x, int[] a) throws Exception {
		return (a != null) && ((x == MyArrayUtil.head(a)) || isIn(x, MyArrayUtil.tail(a)));
	}
	
	public static boolean subArray(int[] a1, int[] a2) throws Exception {
		return (a1 == null) || (isIn(MyArrayUtil.head(a1), a2) && subArray(MyArrayUtil.tail(a1), a2));
	}
	
	public static int[] shift(int[] ht, int n) throws Exception {
		if (ht == null) return null;
		if (n <= 0) return ht;
		int head = MyArrayUtil.head(ht);
		int[] tail = MyArrayUtil.tail(ht);
		return shift(reverse(MyArrayUtil.addAsFirst(head, reverse(tail))), --n);
	}
	
	public static void main(String[] args) throws Exception {
		// test append, when appending empty array with {1,2,3}
		int[] a = null;
		int[] b = {1,2,3};
		int[] ans1 = append(a,b);
		System.out.println("Append - Expected: 1, 2, 3.");
		System.out.print("Get: ");
		MyArrayUtil.print(ans1);
		System.out.println("");
		
		// test append, when appending 2 non-empty arrays.
		int[] c = {1,2,3};
		int[] d = {4,5,6};
		ans1 = append(c,d);
		System.out.println("Append - Expected: 1, 2, 3, 4, 5, 6.");
		System.out.print("Get: ");
		MyArrayUtil.print(ans1);
		System.out.println("");
		
		// test reverse
		int[] e = {1,2,3,4,5};
		ans1 = reverse(e);
		System.out.println("Reverse - Expected: 5, 4, 3, 2, 1.");
		System.out.print("Get: ");
		MyArrayUtil.print(ans1);
		System.out.println("");

		// test isIn
		boolean b1 = isIn(3, e);
		System.out.println("isIn - Expected: true.");
		System.out.println("Get: " + b1 +".");
		
		boolean b2 = isIn(7, e);
		System.out.println("isIn - Expected: false.");
		System.out.println("Get: " + b2 +".");
		
		// test subArray
		int[] f = {1,3,5};
		int[] g = {1,2,3,4,5};
		int[] h = {1,2,3,4,5};
		int[] i = null;
		int[] j = {1,4,5};
		
		b1 = subArray(f, g);
		System.out.println("subArray - Expected: true.");
		System.out.println("Get: " + b1 +".");
		
		b1 = subArray(g, h);
		System.out.println("subArray - Expected: true.");
		System.out.println("Get: " + b1 +".");
		
		b1 = subArray(i, h);
		System.out.println("subArray - Expected: true.");
		System.out.println("Get: " + b1 +".");
		
		b1 = subArray(f, j);
		System.out.println("subArray - Expected: false.");
		System.out.println("Get: " + b1 +".");
		
		b1 = subArray(h, j);
		System.out.println("subArray - Expected: false.");
		System.out.println("Get: " + b1 +".");
		
		//test shift
		int[] k = shift(g,3);
		System.out.println("shift - Expected: 4, 5, 1, 2, 3.");
		System.out.print("Get: ");
		MyArrayUtil.print(k);
		System.out.println("");
		
		k = shift(g,2);
		System.out.println("shift - Expected: 3, 4, 5, 1, 2.");
		System.out.print("Get: ");
		MyArrayUtil.print(k);
		System.out.println("");
		
		k = shift(g,8);
		System.out.println("shift - Expected: 4, 5, 1, 2, 3.");
		System.out.print("Get: ");
		MyArrayUtil.print(k);
		System.out.println("");
		
		k = shift(g,0);
		System.out.println("shift - Expected: 1, 2, 3, 4, 5.");
		System.out.print("Get: ");
		MyArrayUtil.print(k);
		System.out.println("");
		
		k = shift(null,5);
		System.out.println("shift - Expected: Array empty");
		System.out.print("Get: ");
		MyArrayUtil.print(k);
		System.out.println("");
	}

}
