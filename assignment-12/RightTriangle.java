public class RightTriangle extends Shape {

    public RightTriangle() {
        super();
    }

    public RightTriangle(int x, char c, int i) {
        super(x, c, i);
    }

    public double getArea() { return rows * rows / 2.0; }
    public double getPerimeter() { return 2 * Math.sqrt(rows * rows + (rows / 2.0) * (rows / 2.0)) + rows; }

    public void draw() {
        String c = character + "";
        for (int p = 0; p < rows; p++) {
            if (indent > 0) System.out.printf("%s", " ".repeat(indent));
            if (p == 0 || p == 1 || p == rows - 1) System.out.printf("%s%n", c.repeat(p + 1));
            else System.out.printf("%c%s%c%n", character, " ".repeat(p - 1), character);
        }
    }

    public void fill() {
        String c = character + "";
        for (int p = 0; p < rows; p++) {
            if (indent > 0) System.out.printf("%s", " ".repeat(indent));
            System.out.printf("%s%n", c.repeat(p + 1));
        }
    }

}
