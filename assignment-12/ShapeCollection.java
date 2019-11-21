import java.util.ArrayList;
import java.util.Iterator;

public class ShapeCollection {
	public static void main(String[] args) {
		ArrayList<Shape> upDownArrow = new ArrayList<Shape>();
		upDownArrow.add(new Triangle(7, '*', 0));
		upDownArrow.add(new Square(5, '&', 4));
		upDownArrow.add(new Square(3, 'x', 5));
		Triangle triangle = new Triangle(7, '*', 0);
		triangle.setVerticalFlip(true);
		upDownArrow.add(triangle);
		System.out.printf("The total area is %.1f %n", computeArea(upDownArrow));
		draw(upDownArrow);
	}

	public static double computeArea(ArrayList<Shape> shapeList) {
		double totalArea = 0;
		for (Shape shape : shapeList) {
			totalArea += shape.getArea();
		}
		return totalArea;
	}

	public static void draw(ArrayList<Shape> shapeList) {
		shapeList.get(0).draw();
		shapeList.get(1).fill();
		shapeList.get(2).draw();
		shapeList.get(3).fill();
	}
}
