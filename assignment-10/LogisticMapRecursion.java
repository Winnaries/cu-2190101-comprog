
public class LogisticMapRecursion {

    public static void main(String[] args) {
        for (int i = 0; i <= 5; i ++) System.out.printf("x(%d) = %.4f %n", i, x(i));
    }

    public static double x(int n) {
        if (n > 0) return (3 * x(n - 1)) * (1 - x(n - 1));
        else return 0.01;
    }

}


