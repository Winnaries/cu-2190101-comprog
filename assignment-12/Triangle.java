public class Triangle extends Shape {

    protected boolean isVerticalFlip;

    public Triangle() {
        super();
        isVerticalFlip = false;
    }

    public Triangle(int x, char c, int i) {
        super(x, c, i);
        isVerticalFlip = false;
    }

    public double getArea() { return rows * rows / 2.0; }
    public double getPerimeter() { return 2 * Math.sqrt(rows * rows + (rows / 2.0) * (rows / 2.0)) + rows; }

    public boolean isVerticalFlip() { return isVerticalFlip; }
    public void setVerticalFlip(boolean b) { isVerticalFlip = b;}

    public void fill() {
        String body = "";
        if (!isVerticalFlip) {
            for (int x = 0; x < rows; x++) {
                if (indent > 0) System.out.printf("%s", " ".repeat(indent));
                body = (character + " ").repeat(x + 1).trim();
                if (x == rows - 1) System.out.printf("%s%n", (character + " ").repeat(x + 1).trim());
                else System.out.printf("%s%s%s%n", " ".repeat(rows - x - 1), body, " ".repeat(rows - x - 1));
            }
            return;
        }
        for (int x = rows - 1; x > -1; x--) {
            if (indent > 0) System.out.printf("%s", " ".repeat(indent));
            body = (character + " ").repeat(x + 1).trim();
            if (x == rows - 1) System.out.printf("%s%n", (character + " ").repeat(x + 1).trim());
            else System.out.printf("%s%s%s%n", " ".repeat(rows - x - 1), body, " ".repeat(rows - x - 1));
        };
    }

    public void draw() {
        String body = "";
        if (!isVerticalFlip) {
            for (int x = 0; x < rows; x++) {
                if (indent > 0) System.out.printf("%s", " ".repeat(indent));
                if (x > 1 && x < rows - 1) body = (character + " ") + "  ".repeat(x - 1) + character;
                else body = (character + " ").repeat(x + 1).trim();
                if (x == rows - 1) System.out.printf("%s%n", body);
                else System.out.printf("%s%s%s%n", " ".repeat(rows - x - 1), body, " ".repeat(rows - x - 1));
            }
            return;
        }
        for (int x = rows - 1; x > -1; x--) {
            if (indent > 0) System.out.printf("%s", " ".repeat(indent));
            if (x > 1 && x < rows - 1) body = (character + " ") + "  ".repeat(x - 1) + character;
            else body = (character + " ").repeat(x + 1).trim();
            if (x == rows - 1) System.out.printf("%s%n", body);
            else System.out.printf("%s%s%s%n", " ".repeat(rows - x - 1), body, " ".repeat(rows - x - 1));
        }
    }
}
