public class Square extends Shape {

    public Square(int x) {
        super();
        setRows(x);
    }

    public Square(int x, char c, int i) {
        super(x, c, i);
    }

    public double getArea() { return rows * rows; }
    public double getPerimeter() { return 4 * rows; }

    public void draw() {
        String spaces = "";
        int a = 0;
        while (a++ < indent) spaces = " ".concat(spaces);
        for (int x = 0; x < rows; x++) {
            System.out.print(spaces);
            if (x > 0 && x < rows - 1) System.out.printf("%c%s%c%n", character, " ".repeat(rows - 2), character);
            else System.out.printf("%s%n", (character + "").repeat(rows));
        }
    }

    public void fill() {
        String spaces = "";
        String body = (character + "").repeat(rows);
        int a = 0;
        int b = 0;
        while (a++ < indent) spaces = " ".concat(spaces);
        while (b++ < rows) System.out.printf("%s%s%n", spaces, body);
    }

}
