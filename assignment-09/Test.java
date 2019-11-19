public class Test {

    public static void main(String[] args) {
        double R, G, B, tr, tg, tb;
        R = Double.parseDouble(args[0]);
        G = Double.parseDouble(args[1]);
        B = Double.parseDouble(args[2]);
        tr = 0.393 * R + 0.769 * G + 0.189 * B;
        tg = 0.349 * R + 0.686 * G + 0.168 * B;
        tb = 0.272 * R + 0.534 * G + 0.131 * B;
        System.out.printf("%.2f %.2f %.2f %n", tr, tg, tb);
    }

}
