
public class TestDraw3 {
	public static void main(String[] args) {
		Shape triangle1 = new Triangle(7, '*', 2);
		System.out.println(triangle1.getArea());
		triangle1.fill();
	}
}
