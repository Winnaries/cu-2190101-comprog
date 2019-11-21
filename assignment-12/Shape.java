public class Shape {

    protected int rows;
    protected char character;
    protected int indent;

    public Shape() {
        this(0, ' ', 0);
    }

    public Shape(int x, char c, int i) {
        setRows(x);
        setCharacter(c);
        setIndent(i);
    }

    public int getRows() { return rows; }
    public void setRows(int x) { rows = x; }

    public char getCharacter() { return character; }
    public void setCharacter(char c) { character = c; }

    public int getIndent() { return indent; }
    public void setIndent(int i) { indent = i;}

    public String toString() {
        return "(rows: " + getRows()
                + ", characters: " + getCharacter()
                + ", indent: " + getIndent()
                + ")";
    }

    public double getArea() {
        return 1.0;
    }

    public void draw() {
        System.out.println("Do not know what shape to draw/fill yet!");
    }

    public void fill() {
        System.out.println("Do not know what shape to draw/fill yet!");
    }

}
