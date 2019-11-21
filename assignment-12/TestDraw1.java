
public class TestDraw1 {
	public static void main(String[] args) {
		Shape shape = new Shape(7,'*', 2);
		System.out.println(shape.getArea());
		shape.draw();
	}
}

